package com.project.tripmateapi;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String country;
    private String city;
    @Lob
    private String description;

    public Destination(Integer id, String country, String city, String description) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.description = description;
    }

    public Destination() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return Objects.equals(id, that.id) && Objects.equals(country, that.country) && Objects.equals(city, that.city) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city, description);
    }
}
