// ================= SAFETY CHECK =================
if (typeof sessions === "undefined" || !Array.isArray(sessions)) {
    console.warn("No analytics data found, using fallback");
    sessions = [
        {
            date: "Today",
            focusMinutes: 0,
            breakMinutes: 0
        }
    ];
}

// ================= DATA =================
const labels = sessions.map(s => s.date || "Today");
const focusMinutes = sessions.map(s => Number(s.focusMinutes) || 0);
const breakMinutes = sessions.map(s => Number(s.breakMinutes) || 0);

// ================= FOCUS LINE CHART =================
new Chart(document.getElementById("focusChart"), {
    type: "line",
    data: {
        labels: labels,
        datasets: [{
            label: "Focus Minutes",
            data: focusMinutes,
            borderColor: "#6fb1ff",
            backgroundColor: "rgba(111,177,255,0.25)",
            borderWidth: 2,
            fill: true,
            tension: 0.35,
            pointRadius: 4
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
            legend: {
                labels: {
                    color: "#8aa4ff"
                }
            }
        },
        scales: {
            x: {
                ticks: { color: "#8aa4ff" },
                grid: { color: "rgba(255,255,255,0.05)" }
            },
            y: {
                beginAtZero: true,
                ticks: { color: "#8aa4ff" },
                grid: { color: "rgba(255,255,255,0.05)" }
            }
        }
    }
});

// ================= BREAK BAR CHART =================
new Chart(document.getElementById("breakChart"), {
    type: "bar",
    data: {
        labels: labels,
        datasets: [{
            label: "Break Minutes",
            data: breakMinutes,
            backgroundColor: "rgba(255,170,90,0.65)",
            borderColor: "#ffaa5a",
            borderWidth: 1,
            borderRadius: 6
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
            legend: {
                labels: {
                    color: "#8aa4ff"
                }
            }
        },
        scales: {
            x: {
                ticks: { color: "#8aa4ff" },
                grid: { color: "rgba(255,255,255,0.05)" }
            },
            y: {
                beginAtZero: true,
                ticks: { color: "#8aa4ff" },
                grid: { color: "rgba(255,255,255,0.05)" }
            }
        }
    }
});
