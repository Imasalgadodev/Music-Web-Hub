package Ima.Salgado.MusicWebHub.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "band")
@Data
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


    public String getBandName() {
        return null;
    }
}
