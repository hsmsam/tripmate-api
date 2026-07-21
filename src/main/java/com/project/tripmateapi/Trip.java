package com.project.tripmateapi;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tripName;
    private String travellerName;
    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal budget;

    public Trip() {

    }

    public Trip(String tripName, String travellerName, Destination destination, LocalDate startDate, LocalDate endDate, BigDecimal budget) {
        this.tripName = tripName;
        this.travellerName = travellerName;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public Integer getId() {
        return id;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getTravellerName() {
        return travellerName;
    }

    public void setTravellerName(String travellerName) {
        this.travellerName = travellerName;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Trip trip = (Trip) object;
        return Objects.equals(id, trip.id) && Objects.equals(tripName, trip.tripName) && Objects.equals(travellerName, trip.travellerName) && Objects.equals(destination, trip.destination) && Objects.equals(startDate, trip.startDate) && Objects.equals(endDate, trip.endDate) && Objects.equals(budget, trip.budget);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tripName, travellerName, destination, startDate, endDate, budget);
    }
}
