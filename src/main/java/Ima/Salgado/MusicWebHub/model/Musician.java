package Ima.Salgado.MusicWebHub.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "musicians")
@Data
public class Musician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String country;
    private String city;
    private String phoneNumber;
    private String email;
    private String instrumentsPlayed; // Comma-separated list
    private String mainInstrument;
    private String bandName;
    private String musicalInfluences;
    private String history; // Bands previously played in
    private String availability;
    private String status; // "Looking for band", "Looking for shows", "Not available"
    private String equipment;

    @ManyToMany(mappedBy = "bandMembersList")
    private List<Band> bands;


}
