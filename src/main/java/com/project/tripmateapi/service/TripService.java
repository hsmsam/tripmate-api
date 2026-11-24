package com.project.tripmateapi.service;

import com.project.tripmateapi.entity.Destination;
import com.project.tripmateapi.entity.Trip;
import com.project.tripmateapi.repository.TripRepository;
import com.project.tripmateapi.dto.TripSummary;
import com.project.tripmateapi.repository.DestinationRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TripService {
    private final TripRepository tripRepository;
    private final DestinationRepository destinationRepository;

    public TripService(TripRepository tripRepository, DestinationRepository destinationRepository) {
        this.tripRepository = tripRepository;
        this.destinationRepository = destinationRepository;
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(Integer id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + " not found"));
    }

    public List<Trip> getTripsByDestination(Integer id) {
        Destination destination = destinationRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("no trips found for destination"));
        return tripRepository.findByDestination(destination);
    }

    public List<Trip> getTripByBudget(BigDecimal max) {
        return tripRepository.findByBudgetLessThanEqual(max);
    }

    public BigDecimal getTotalExperienceCost(Integer id) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Trip not found"));

        return trip.getTotalExperienceCost();
    }

    public Double getAverageExperienceRating(Integer id) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Trip not found"));

        return trip.getAverageExperienceRating();
    }

    public BigDecimal getTotalSpentOnTrip(Integer id) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Trip not found"));

        return trip.getTotalSpent();
    }

    public BigDecimal getRemainingBudgetOnTrip(Integer id) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Trip not found"));

        return trip.getRemainingBudget();
    }

    public Integer getNumberOfExperiences(Integer id) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Trip not found"));

        return trip.getNumberOfExperiences();
    }

    public void addANewTrip(Trip trip) {
        tripRepository.save(trip);
    }

    public void updateTripDetails(Integer id, Trip trip) {
        Trip tripExists = tripRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Trip doesn't exist"));

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

    public TripSummary getTripSummary(Integer id) {
        Trip trip = tripRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Trip doesn't exist"));

        return new TripSummary(
                trip.getTripName(),
                trip.getBudget(),
                trip.getTotalSpent(),
                trip.getRemainingBudget(),
                trip.getNumberOfExperiences(),
                trip.getAverageExperienceRating(),
                trip.getBestRatedExperience(),
                trip.getMostCommonActivity()
        );
    }
}
