package com.example.FocusMate.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.FocusMate.Entity.User;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String showProfile(HttpSession session, Model model) {

        User user = (User) session.getAttribute("loggedUser");

        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);

        return "profile"; // profile.html
    }
}
