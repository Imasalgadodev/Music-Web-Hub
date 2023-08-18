package Ima.Salgado.MusicWebHub.controller;

import Ima.Salgado.MusicWebHub.model.User;
import Ima.Salgado.MusicWebHub.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        User user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return "redirect:/dashboard"; // Página después del inicio de sesión exitoso
        } else {
            model.addAttribute("errorMessage", "Credenciales inválidas");
            return "login";
        }
    }
}

