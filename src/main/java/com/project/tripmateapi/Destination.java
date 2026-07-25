package com.project.tripmateapi;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    private String country;
    @Column(columnDefinition = "TEXT")
    private String description;

    public Destination() {

    }

    public Destination(String city, String country, String description) {
        this.city = city;
        this.country = country;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Destination that = (Destination) object;
        return Objects.equals(id, that.id) && Objects.equals(city, that.city) && Objects.equals(country, that.country) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, country, description);
    }
}
