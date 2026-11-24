package com.project.tripmateapi.repository;

import com.project.tripmateapi.entity.Destination;
import com.project.tripmateapi.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Integer> {
    List<Trip> findByDestination(Destination destination);

    List<Trip> findByBudgetLessThanEqual(BigDecimal max);

}
