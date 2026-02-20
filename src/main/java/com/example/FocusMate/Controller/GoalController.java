package com.example.FocusMate.Controller;

import com.example.FocusMate.Entity.User;
import com.example.FocusMate.Entity.DailyGoal;
import com.example.FocusMate.Service.DailyGoalService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class GoalController {

    private final DailyGoalService goalService;

    // ✅ Updated method with progressPercent calculation
    @GetMapping("/goals")
    public String goalsPage(HttpSession session, Model model){
        User user = (User) session.getAttribute("loggedUser");
        if(user == null) return "redirect:/login";

        DailyGoal goal = goalService.getTodayGoals(user.getUserId());
        int progressPercent = 0;

        if(goal != null && goal.getTargetMinutes() != null && goal.getTargetMinutes() > 0){
            progressPercent = goal.getCompletedMinutes() * 100 / goal.getTargetMinutes();
        }

        model.addAttribute("goal", goal);
        model.addAttribute("progressPercent", progressPercent);

        return "goals";
    }

    @PostMapping("/set-goal")
    public String setGoal(@RequestParam String goalText, HttpSession session){
        User user = (User) session.getAttribute("loggedUser");
        if(user == null) return "redirect:/login";

        goalService.setGoal(user.getUserId(), goalText);
        return "redirect:/goals";
    }
}
