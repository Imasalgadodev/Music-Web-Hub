package Ima.Salgado.MusicWebHub.service;

import Ima.Salgado.MusicWebHub.model.Venue;
import Ima.Salgado.MusicWebHub.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {

    private final VenueRepository venueRepository;

    @Autowired
    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public List<Venue> getVenues() {
        return venueRepository.findAll();
    }

}
