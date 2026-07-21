package com.project.tripmateapi;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TripService {
    TripRepository tripRepository;
    DestinationRepository destinationRepository;

    public TripService(TripRepository tripRepository, DestinationRepository destinationRepository) {
        this.tripRepository = tripRepository;
        this.destinationRepository = destinationRepository;
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(Integer id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + "not found"));
    }

    public List<Trip> getTripsByDestination(Integer id) {
        Destination destination = destinationRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("no trips found for destination"));

        return tripRepository.findByDestination(destination);
    }

    public void addANewTrip(Trip trip) {
        tripRepository.save(trip);
    }

    public void updateTripDetails(Integer id, Trip trip) {
        Trip tripExists = tripRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("trip doesn't exist"));

        if (trip.getTripName() != null) {
            tripExists.setTripName(trip.getTripName());
        }
        if (trip.getTravellerName() != null) {
            tripExists.setTravellerName(trip.getTravellerName());
        }
        if (trip.getDestination() != null) {
            tripExists.setDestination(trip.getDestination());
        }
        if (trip.getStartDate() != null) {
            tripExists.setStartDate(trip.getStartDate());
        }
        if (trip.getEndDate() != null) {
            tripExists.setEndDate(trip.getEndDate());
        }
        if (trip.getBudget() != null && trip.getBudget().compareTo(BigDecimal.ZERO) >= 0) {
            tripExists.setBudget(trip.getBudget());
        }

        tripRepository.save(tripExists);
    }

    public void removeTrip(Integer id) {
        tripRepository.deleteById(id);
    }
}
