package Ima.Salgado.MusicWebHub.service;

import Ima.Salgado.MusicWebHub.model.Musician;
import Ima.Salgado.MusicWebHub.repository.MusicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MusicianService {

    private MusicianRepository musicianRepository;
    private BandService bandService;

    @Autowired
    public MusicianService(MusicianRepository musicianRepository, BandService bandService) {
        this.musicianRepository = musicianRepository;
        this.bandService = bandService;
    }

    public boolean createMusician(Musician musician) {

        if ("Looking for Band".equals(musician.getStatus()) && musician.getBandName().isEmpty()) {
            musicianRepository.save(musician);
            return true;
        }

        if (bandService.doesBandExist(musician.getBandName())) {
            musicianRepository.save(musician);
            return true;
        }

        return false;
    }

    public List<Musician> getMusicians() {
        return musicianRepository.findAll();
    }

    public Musician getMusician(Long id) {
        return musicianRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Musician not found with ID: " + id));
    }
}
