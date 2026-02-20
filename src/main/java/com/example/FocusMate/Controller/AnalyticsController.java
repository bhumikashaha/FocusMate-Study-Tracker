package com.example.FocusMate.Controller;

import com.example.FocusMate.Entity.User;
import com.example.FocusMate.Service.SessionRecordService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AnalyticsController {

    private final SessionRecordService sessionService;

    @GetMapping("/analytics")
    public String analyticsPage(HttpSession session, Model model) {

        User user = (User) session.getAttribute("loggedUser");
        if (user == null) return "redirect:/login";

        model.addAttribute(
                "sessions",
                sessionService.getAllSessions(user.getUserId())
        );

        return "analytics";
    }

}
