package Ima.Salgado.MusicWebHub.controller;

import Ima.Salgado.MusicWebHub.model.Musician;
import Ima.Salgado.MusicWebHub.service.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    private final MusicianService musicianService;
    private final Validations validations;

    @Autowired
    public MusicianController(MusicianService musicianService, Validations validations) {
        this.musicianService = musicianService;
        this.validations = validations;
    }


    @GetMapping("/musician/create")
    public String showCreateForm(Model model) {
        model.addAttribute("musician", new Musician());
        return "create_musician";
    }

    @PostMapping("/musician/create")
    public String createMusician(@ModelAttribute Musician musician, Model model) {
        // Validar el formato del correo electrónico
        if (!validations.isValidEmail(musician.getEmail())) {
            model.addAttribute("errorMessage", "Email inválido");
            return "create_musician"; // Redirigir a la página de creación con mensaje de error
        }

        // Validar el formato del número de teléfono
        if (!validations.isValidPhoneNumber(musician.getPhoneNumber())) {
            model.addAttribute("errorMessage", "Número de teléfono inválido");
            return "create_musician"; // Redirigir a la página de creación con mensaje de error
        }

        // Intentar crear al músico
        boolean isMusicianCreated = musicianService.createMusician(musician);
        if (isMusicianCreated) {
            return "redirect:/musicians"; // Redirigir a la lista de músicos si se crea exitosamente
        } else {
            model.addAttribute("errorMessage", "Banda no encontrada.");
            return "create_musician"; // Redirigir a la página de creación con mensaje de error
        }
    }

    @GetMapping("/musicians")
    @PreAuthorize("hasRole('Musician') or hasRole('admin')")
    public String listMusicians(Model model) {

        List<Musician> musicians = musicianService.getMusicians();
        model.addAttribute("musicians", musicians);
        return "list_musicians"; // Thymeleaf template name
    }

    @GetMapping("/musician/{id}")
    public String musicianProfile(@PathVariable Long id, Model model) {
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
