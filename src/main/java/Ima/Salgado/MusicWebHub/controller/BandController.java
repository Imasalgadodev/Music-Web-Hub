package Ima.Salgado.MusicWebHub.controller;


import Ima.Salgado.MusicWebHub.model.Band;
import Ima.Salgado.MusicWebHub.repository.BandRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BandController {

    private final BandRepository bandRepository;

    public BandController(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }

    @GetMapping("/bands")
    public String listBands(Model model) {
        Iterable<Band> bands = bandRepository.findAll();
        model.addAttribute("bands", bands);
        return "list_bands";
    }
}

