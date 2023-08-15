package Ima.Salgado.MusicWebHub.controller;

import Ima.Salgado.MusicWebHub.model.Musician;
import Ima.Salgado.MusicWebHub.repository.MusicianRepository;
import Ima.Salgado.MusicWebHub.service.BandService;
import Ima.Salgado.MusicWebHub.service.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class MusicianController {

    private MusicianService musicianService;

    @Autowired
    public MusicianController(MusicianService musicianService) {
        this.musicianService = musicianService;
    }


    @GetMapping("/musician/create")
    public String showCreateForm(Model model) {
        model.addAttribute("musician", new Musician());
        return "create_musician";
    }

    @PostMapping("/musician/create")
    public String createMusician(@ModelAttribute Musician musician, Model model) {
        boolean isMusicianCreated = musicianService.createMusician(musician);
        if(isMusicianCreated) {
            return "redirect:/musicians";
        } else {
            model.addAttribute("errorMessage", "Banda no encontrada.");
            return "create_musician"; // Redirigir nuevamente a la página de creación
        }

    }

    @GetMapping("/musicians")
    public String listMusicians(Model model) {

        List<Musician> musicians = musicianService.getMusicians();
        model.addAttribute("musicians", musicians);
        return "list_musicians"; // Thymeleaf template name
    }

    @GetMapping("/musician/{id}")
    public String musicianProfile(@PathVariable Long id, Model model) {
        System.out.println("Musician ID: " + id); // línea para depurar
        try {
            Musician musician = musicianService.getMusician(id);
            model.addAttribute("musician", musician);
            return "musician_profile";
        } catch (ResponseStatusException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        } catch (Exception e) {
            model.addAttribute("error", "An unexpected error occurred.");
            return "error";
        }
    }


}
