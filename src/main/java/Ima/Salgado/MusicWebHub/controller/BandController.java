package Ima.Salgado.MusicWebHub.controller;


import Ima.Salgado.MusicWebHub.model.Band;
import Ima.Salgado.MusicWebHub.repository.BandRepository;
import Ima.Salgado.MusicWebHub.service.BandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BandController {

    private final BandRepository bandRepository;
    private final BandService bandService;
    private final Validations validations;

    public BandController(BandRepository bandRepository, BandService bandService, Validations validations) {
        this.bandRepository = bandRepository;
        this.bandService = bandService;
        this.validations = validations;
    }

    @GetMapping("/band/create")
    public String showCreateForm(Model model){
        model.addAttribute("band", new Band());
        return "create_band";
    }

    @PostMapping("/band/create")
    public String createBand(@ModelAttribute Band band, Model model){
        // Validar el formato del correo electrónico
        if (!validations.isValidEmail(band.getEmail())) {
            model.addAttribute("errorMessage", "Email inválido");
            return "create_band"; // Redirigir a la página de creación con mensaje de error
        }

        // Validar el formato del número de teléfono
        if (!validations.isValidPhoneNumber(band.getPhoneNumber())) {
            model.addAttribute("errorMessage", "Número de teléfono inválido");
            return "create_band"; // Redirigir a la página de creación con mensaje de error
        }

        // Intentar crear al músico
        boolean isBandCreated = bandService.createBand(band);
        if (isBandCreated) {
            return "redirect:/bands"; // Redirigir a la lista de bandas si se crea exitosamente
        } else {
            model.addAttribute("errorMessage", "Banda no encontrada.");
            return "create_band"; // Redirigir a la página de creación con mensaje de error
        }
    }

    @GetMapping("/bands")
    public String listBands(Model model) {
        Iterable<Band> bands = bandRepository.findAll();
        model.addAttribute("bands", bands);
        return "list_bands";
    }
}

