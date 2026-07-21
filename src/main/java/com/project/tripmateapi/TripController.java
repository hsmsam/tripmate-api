package com.project.tripmateapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tripmate-api/trip")
public class TripController {
    TripService tripService;

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
