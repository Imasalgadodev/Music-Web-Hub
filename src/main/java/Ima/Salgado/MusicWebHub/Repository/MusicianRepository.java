package Ima.Salgado.MusicWebHub.Repository;

import Ima.Salgado.MusicWebHub.Model.Musician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicianRepository extends JpaRepository<Musician, Long> {

}

