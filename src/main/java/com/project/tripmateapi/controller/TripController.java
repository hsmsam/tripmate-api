package com.project.tripmateapi.controller;

import com.project.tripmateapi.entity.Trip;
import com.project.tripmateapi.dto.TripSummary;
import com.project.tripmateapi.service.TripService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/v1/trip")
public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("{id}")
    public Trip getTripById(@PathVariable Integer id) {
        return tripService.getTripById(id);
    }

    @GetMapping("/destination/{id}")
    public List<Trip> getTripsByDestination(@PathVariable Integer id) {
        return tripService.getTripsByDestination(id);
    }

    @GetMapping("/budget/{max}")
    public List<Trip> getTripsByBudget(@PathVariable BigDecimal max) {
        return tripService.getTripByBudget(max);
    }

    @GetMapping("/{id}/total-cost")
    public BigDecimal getTotalExperienceCost(@PathVariable Integer id) {
        return tripService.getTotalExperienceCost(id);
    }

    @GetMapping("/{id}/average-rating")
    public Double getAverageExperienceRating(@PathVariable Integer id) {
        return tripService.getAverageExperienceRating(id);
    }

    @GetMapping("{id}/total-spent")
    public BigDecimal getTotalSpentOnTrip(@PathVariable Integer id) {
        return tripService.getTotalSpentOnTrip(id);
    }

    @GetMapping("{id}/remaining-budget")
    public BigDecimal getRemainingBudgetOnTrip(@PathVariable Integer id) {
        return tripService.getRemainingBudgetOnTrip(id);
    }

    @GetMapping("{id}/number-of-experiences")
    public Integer getNumberOfExperiences(@PathVariable Integer id) {
        return tripService.getNumberOfExperiences(id);
    }

    @GetMapping("/{id}/summary")
    public TripSummary getTripSummary(@PathVariable Integer id) {
        return tripService.getTripSummary(id);
    }

    @PostMapping
    public void addANewTrip(@RequestBody Trip trip) {
        tripService.addANewTrip(trip);
    }

    @PutMapping("/{id}")
    public void updateTripDetails(@PathVariable Integer id, @RequestBody Trip trip) {
        tripService.updateTripDetails(id, trip);

    }

    @DeleteMapping("{id}")
    public void removeTrip(@PathVariable Integer id) {
        tripService.removeTrip(id);
    }
}
