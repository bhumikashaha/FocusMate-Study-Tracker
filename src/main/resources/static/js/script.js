let defaultMinutes = 25;
let remainingSeconds = defaultMinutes * 60;
let interval = null;
let isRunning = false;

const timerEl = () => document.getElementById('timer');

function formatTime(seconds) {
    const m = Math.floor(seconds / 60).toString().padStart(2, '0');
    const s = (seconds % 60).toString().padStart(2, '0');
    return `${m}:${s}`;
}

function render() {
    if (timerEl()) timerEl().textContent = formatTime(remainingSeconds);
}

function startTimer() {
    if (isRunning) return;
    isRunning = true;
    interval = setInterval(() => {
        remainingSeconds -= 1;
        render();
        if (remainingSeconds <= 0) {
            clearInterval(interval);
            isRunning = false;
            onTimerComplete();
        }
    }, 1000);
}

function pauseTimer() {
    clearInterval(interval);
    isRunning = false;
}

function resetTimer() {
    pauseTimer();
    remainingSeconds = defaultMinutes * 60;
    render();
}

function onTimerComplete() {
    const el = timerEl();
    if (!el) return;
    el.textContent = '00:00';
    saveSession(defaultMinutes);
    if (window.Notification && Notification.permission !== 'denied') {
        Notification.requestPermission().then(() => {
            new Notification('FocusMate', { body: 'Pomodoro finished — session saved.' });
        });
    }
}

async function saveSession(minutes) {
    try {
        const resp = await fetch('/pomodoro/save-session', {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            body: `minutes=${encodeURIComponent(minutes)}`
        });
        if (!resp.ok) console.warn('Session save failed:', resp.statusText);
        else console.log('Session saved');
    } catch (e) {
        console.error('Save error', e);
    }
}

window.addEventListener('DOMContentLoaded', render);
fetch("/pomodoro-complete", { method: "POST" });
