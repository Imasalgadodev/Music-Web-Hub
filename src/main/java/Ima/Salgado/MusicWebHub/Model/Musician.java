package Ima.Salgado.MusicWebHub.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
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

    // Getter and Setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstrumentsPlayed() {
        return instrumentsPlayed;
    }

    public void setInstrumentsPlayed(String instrumentsPlayed) {
        this.instrumentsPlayed = instrumentsPlayed;
    }

    public String getMainInstrument() {
        return mainInstrument;
    }

    public void setMainInstrument(String mainInstrument) {
        this.mainInstrument = mainInstrument;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getMusicalInfluences() {
        return musicalInfluences;
    }

    public void setMusicalInfluences(String musicalInfluences) {
        this.musicalInfluences = musicalInfluences;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public Musician() {
    }
}
