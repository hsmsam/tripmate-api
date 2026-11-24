package com.project.tripmateapi;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
    @OneToMany(mappedBy = "trip")
    @JsonManagedReference
    private List<Experience> experiences;

    public Trip() {

    }

    public Trip(String tripName, String travellerName, Destination destination, LocalDate startDate, LocalDate endDate, BigDecimal budget, List<Experience> experiences) {
        this.tripName = tripName;
        this.travellerName = travellerName;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.experiences = experiences;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getTotalExperienceCost() {
        if (experiences == null || experiences.isEmpty()) {
            return BigDecimal.ZERO;
        }

        return experiences.stream()
                .map(Experience::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public double getAverageExperienceRating() {
        if (experiences == null || experiences.isEmpty()) {
            return 0.0;
        }

        return experiences.stream().mapToDouble(Experience::getRating).average().orElse(0.0);
    }

    public BigDecimal getTotalSpent() {
        return getTotalExperienceCost();
    }

    public BigDecimal getRemainingBudget() {
        return budget.subtract(getTotalSpent());
    }

    public int getNumberOfExperiences() {
        if (experiences == null || experiences.isEmpty()) {
            return 0;
        }

        return experiences.size();
    }

    public Experience getBestRatedExperience() {
        if (experiences == null || experiences.isEmpty()) {
            return null;
        }

        return experiences.stream()
                .max(Comparator.comparingDouble(Experience::getRating))
                .orElse(null);
    }

    public ActivityType getMostCommonActivity() {
        if (experiences == null || experiences.isEmpty()) {
            return null;
        }

        return experiences.stream()
                .collect(Collectors.groupingBy(Experience::getActivity, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Trip trip = (Trip) object;
        return Objects.equals(id, trip.id) && Objects.equals(tripName, trip.tripName) && Objects.equals(travellerName, trip.travellerName) && Objects.equals(destination, trip.destination) && Objects.equals(startDate, trip.startDate) && Objects.equals(endDate, trip.endDate) && Objects.equals(budget, trip.budget) && Objects.equals(experiences, trip.experiences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tripName, travellerName, destination, startDate, endDate, budget, experiences);
    }
}
