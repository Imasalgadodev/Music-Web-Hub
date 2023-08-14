package Ima.Salgado.MusicWebHub.controller;

import Ima.Salgado.MusicWebHub.model.Musician;
import Ima.Salgado.MusicWebHub.repository.MusicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/musician/{id}")
    public String musicianProfile(@PathVariable Long id, Model model) {
        System.out.println("Musician ID: " + id); // línea para depurar
        try {
            Musician musician = musicianRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Musician not found with ID: " + id));

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
