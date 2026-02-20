package com.example.FocusMate.Controller;

import com.example.FocusMate.Entity.User;
import com.example.FocusMate.Service.StreakService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class StreakController {

    private final StreakService streakService;

    @GetMapping("/streak")
    public String streakPage(HttpSession session, Model model){
        User user = (User) session.getAttribute("loggedUser");
        if(user == null) return "redirect:/login";

        model.addAttribute("streak", streakService.getStreak(user.getUserId()));
        return "streak";
    }
}
