package com.example.FocusMate.Controller;

import com.example.FocusMate.Entity.User;
import com.example.FocusMate.Service.DailyGoalService;
import com.example.FocusMate.Service.SessionRecordService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pomodoro")
public class PomodoroController {

    private final SessionRecordService sessionService;
    private final DailyGoalService dailyGoalService;

    @GetMapping
    public String pomodoroPage(HttpSession session){
        if(session.getAttribute("loggedUser") == null)
            return "redirect:/login";

        return "pomodoro";
    }

    @PostMapping("/save-session")
    @ResponseBody
    public String saveSession(@RequestParam int minutes, HttpSession session){
        User user = (User) session.getAttribute("loggedUser");
        if(user == null) return "NOT_LOGGED_IN";

        sessionService.saveSession(user, minutes);
        return "OK";
    }

    /*@PostMapping("/pomodoro-complete")
    @ResponseBody
    public void pomodoroComplete(HttpSession session) {
        User user = (User) session.getAttribute("loggedUser");
        if (user != null) {
            dailyGoalService.addFocusMinutes(user.getUserId(), 25);
        }
    }*/

    @PostMapping("/pomodoro-complete")
    @ResponseBody
    public void pomodoroComplete(
            @RequestParam int minutes,
            HttpSession session
    ) {
        User user = (User) session.getAttribute("loggedUser");
        if (user != null) {
            dailyGoalService.addFocusMinutes(user.getUserId(), minutes);
        }
    }


}
