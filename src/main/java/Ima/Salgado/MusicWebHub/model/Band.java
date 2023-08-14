package Ima.Salgado.MusicWebHub.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "band")
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String startDate;
    private String country;
    private String city;
    private String bandMembers;
    private String roles;
    private String phoneNumber;
    private String email;
    private String musicalStyle;
    private String influencedBy;
    private String status;
    private String showCalendar;
    private String rehearsalSchedule;

    @ManyToMany
    @JoinTable(
            name = "band_musicians",
            joinColumns = @JoinColumn(name = "band_id"),
            inverseJoinColumns = @JoinColumn(name = "musician_id")
    )
    private List<Musician> bandMembersList;

    // Getters and setters for the attributes

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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

    public String getBandMembers() {
        return bandMembers;
    }

    public void setBandMembers(String bandMembers) {
        this.bandMembers = bandMembers;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
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

    public String getMusicalStyle() {
        return musicalStyle;
    }

    public void setMusicalStyle(String musicalStyle) {
        this.musicalStyle = musicalStyle;
    }

    public String getInfluencedBy() {
        return influencedBy;
    }

    public void setInfluencedBy(String influencedBy) {
        this.influencedBy = influencedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShowCalendar() {
        return showCalendar;
    }

    public void setShowCalendar(String showCalendar) {
        this.showCalendar = showCalendar;
    }

    public String getRehearsalSchedule() {
        return rehearsalSchedule;
    }

    public void setRehearsalSchedule(String rehearsalSchedule) {
        this.rehearsalSchedule = rehearsalSchedule;
    }

    public List<Musician> getBandMembersList() {
        return bandMembersList;
    }

    public void setBandMembersList(List<Musician> bandMembersList) {
        this.bandMembersList = bandMembersList;
    }

    // Other methods...
}
