package Ima.Salgado.MusicWebHub.repository;

import Ima.Salgado.MusicWebHub.model.Band;
import org.springframework.data.repository.CrudRepository;

public interface BandRepository extends CrudRepository<Band, Long> {

    Band findByName(String name);
}