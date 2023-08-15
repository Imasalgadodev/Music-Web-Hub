package Ima.Salgado.MusicWebHub.service;

import Ima.Salgado.MusicWebHub.model.Band;
import Ima.Salgado.MusicWebHub.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandService {

    private final BandRepository bandRepository;


    @Autowired
    public BandService(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }

    public boolean doesBandExist(String name) {
        Band band = bandRepository.findByName(name);
        return band != null;
    }
}
