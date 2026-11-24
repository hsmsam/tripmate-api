package com.project.tripmateapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.tripmateapi.enums.ActivityType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "trip_id")
    @JsonBackReference
    private Trip trip;
    private String title;
    @Enumerated(EnumType.STRING)
    private ActivityType activity;
    private BigDecimal price;
    private Double rating;
    @Column(columnDefinition = "TEXT")
    private String review;

    public Experience() {

    }

    public Experience(String title, ActivityType activity, BigDecimal price, Double rating, String review) {
        this.title = title;
        this.activity = activity;
        this.price = price;
        this.rating = rating;
        this.review = review;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ActivityType getActivity() {
        return activity;
    }

    public void setActivity(ActivityType activity) {
        this.activity = activity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Experience that = (Experience) object;
        return Objects.equals(id, that.id) && Objects.equals(trip, that.trip) && Objects.equals(title, that.title) && activity == that.activity && Objects.equals(price, that.price) && Objects.equals(rating, that.rating) && Objects.equals(review, that.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trip, title, activity, price, rating, review);
    }
}
