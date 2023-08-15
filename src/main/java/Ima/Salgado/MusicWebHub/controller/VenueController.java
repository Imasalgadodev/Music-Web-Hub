package Ima.Salgado.MusicWebHub.controller;

import Ima.Salgado.MusicWebHub.model.Venue;
import Ima.Salgado.MusicWebHub.repository.VenueRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VenueController {

    private final VenueRepository venueRepository;

    public VenueController(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @GetMapping("/venues")
    public String listVenues(Model model) {
        Iterable<Venue> venues = venueRepository.findAll();
        model.addAttribute("venues", venues);
        return "list_venues"; // Thymeleaf template name for listing venues
    }
}
