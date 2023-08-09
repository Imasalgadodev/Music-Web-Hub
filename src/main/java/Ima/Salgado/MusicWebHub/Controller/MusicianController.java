package Ima.Salgado.MusicWebHub.Controller;

import Ima.Salgado.MusicWebHub.Model.Musician;
import Ima.Salgado.MusicWebHub.Repository.MusicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MusicianController {
    private final MusicianRepository musicianRepository;

    @Autowired
    public MusicianController(MusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }

    @GetMapping("/musicians")
    public String listMusicians(Model model) {
        List<Musician> musicians = musicianRepository.findAll();
        model.addAttribute("musicians", musicians);
        return "list_musicians"; // Thymeleaf template name
    }
}

