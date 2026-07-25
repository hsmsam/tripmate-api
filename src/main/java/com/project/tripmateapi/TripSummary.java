package com.project.tripmateapi;

import java.math.BigDecimal;
import java.util.Objects;

public class TripSummary {
    private String tripName;
    private BigDecimal budget;
    private BigDecimal totalSpent;
    private BigDecimal remainingBudget;
    private int numberOfExperiences;
    private Double averageRating;
    private Experience bestRatedExperience;
    private ActivityType mostCommonActivity;

    public TripSummary(String tripName, BigDecimal budget, BigDecimal totalSpent, BigDecimal remainingBudget, int numberOfExperiences, Double averageRating, Experience bestRatedExperience, ActivityType mostCommonActivity) {
        this.tripName = tripName;
        this.budget = budget;
        this.totalSpent = totalSpent;
        this.remainingBudget = remainingBudget;
        this.numberOfExperiences = numberOfExperiences;
        this.averageRating = averageRating;
        this.bestRatedExperience = bestRatedExperience;
        this.mostCommonActivity = mostCommonActivity;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(BigDecimal totalSpent) {
        this.totalSpent = totalSpent;
    }

    public BigDecimal getRemainingBudget() {
        return remainingBudget;
    }

    public void setRemainingBudget(BigDecimal remainingBudget) {
        this.remainingBudget = remainingBudget;
    }

    public int getNumberOfExperiences() {
        return numberOfExperiences;
    }

    public void setNumberOfExperiences(int numberOfExperiences) {
        this.numberOfExperiences = numberOfExperiences;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Experience getBestRatedExperience() {
        return bestRatedExperience;
    }

    public void setBestRatedExperience(Experience bestRatedExperience) {
        this.bestRatedExperience = bestRatedExperience;
    }

    public ActivityType getMostCommonActivity() {
        return mostCommonActivity;
    }

    public void setMostCommonActivity(ActivityType mostCommonActivity) {
        this.mostCommonActivity = mostCommonActivity;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        TripSummary that = (TripSummary) object;
        return numberOfExperiences == that.numberOfExperiences && Objects.equals(tripName, that.tripName) && Objects.equals(budget, that.budget) && Objects.equals(totalSpent, that.totalSpent) && Objects.equals(remainingBudget, that.remainingBudget) && Objects.equals(averageRating, that.averageRating) && Objects.equals(bestRatedExperience, that.bestRatedExperience) && mostCommonActivity == that.mostCommonActivity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripName, budget, totalSpent, remainingBudget, numberOfExperiences, averageRating, bestRatedExperience, mostCommonActivity);
    }
}


