let defaultMinutes = 25;
let remainingSeconds = defaultMinutes * 60;
let timerInterval = null;
let isRunning = false;

const timerEl = document.getElementById("timer");
const startBtn = document.getElementById("startBtn");
const pauseBtn = document.getElementById("pauseBtn");
const resetBtn = document.getElementById("resetBtn");

function formatTime(sec) {
    const m = Math.floor(sec / 60).toString().padStart(2, "0");
    const s = (sec % 60).toString().padStart(2, "0");
    return `${m}:${s}`;
}

function render() {
    timerEl.textContent = formatTime(remainingSeconds);
}

function setMinutes(min) {
    if (isRunning) return;
    defaultMinutes = min;
    remainingSeconds = min * 60;
    render();
}

function startTimer() {
    if (isRunning) return;
    isRunning = true;

    timerInterval = setInterval(() => {
        remainingSeconds--;
        render();

        if (remainingSeconds <= 0) {
            clearInterval(timerInterval);
            isRunning = false;
            timerFinished();
        }
    }, 1000);
}

function pauseTimer() {
    clearInterval(timerInterval);
    isRunning = false;
}

function resetTimer() {
    pauseTimer();
    remainingSeconds = defaultMinutes * 60;
    render();
}

function timerFinished() {
    timerEl.textContent = "00:00";

    // 🔥 Save focus minutes
    fetch("/pomodoro/save-session", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: `minutes=${defaultMinutes}`
    });

    alert("🎉 Focus session completed!");
}

startBtn.addEventListener("click", startTimer);
pauseBtn.addEventListener("click", pauseTimer);
resetBtn.addEventListener("click", resetTimer);

render();
