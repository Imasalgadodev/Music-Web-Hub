package Ima.Salgado.MusicWebHub.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String photoUrl;
    private String description;
    private String city;
    private String country;
    private Date publishedDate;
    private String type;
    private String status;
    private double price;
    private String comments;

}

