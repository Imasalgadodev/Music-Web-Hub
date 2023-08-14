package Ima.Salgado.MusicWebHub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index"; // Esto redirigirá a "index.html" en la carpeta de recursos estáticos
    }
}
