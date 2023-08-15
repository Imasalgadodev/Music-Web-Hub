package Ima.Salgado.MusicWebHub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "venues")
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

    // Getters and setters...

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getShowCalendar() {
        return showCalendar;
    }

    public void setShowCalendar(String showCalendar) {
        this.showCalendar = showCalendar;
    }

    public String getActiveShows() {
        return activeShows;
    }

    public void setActiveShows(String activeShows) {
        this.activeShows = activeShows;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Constructor...

    public Venue() {
    }
}
