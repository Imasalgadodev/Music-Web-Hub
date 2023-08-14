package Ima.Salgado.MusicWebHub.repository;

import Ima.Salgado.MusicWebHub.model.Musician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicianRepository extends JpaRepository<Musician, Long> {

}

