package Ima.Salgado.MusicWebHub.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "venues")
@Data
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String country;
    private String location;
    private String showCalendar;
    private String activeShows;
    private int capacity;
    private String status;
    private String description;


}
