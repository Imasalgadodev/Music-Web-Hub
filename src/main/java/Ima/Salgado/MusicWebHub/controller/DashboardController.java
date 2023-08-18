package Ima.Salgado.MusicWebHub.controller;

import Ima.Salgado.MusicWebHub.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");

        if (user != null) {
            model.addAttribute("user", user);
            return "dashboard";
        } else {
            return "redirect:/login";
        }
    }
}

