package com.project.tripmateapi.repository;

import com.project.tripmateapi.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Integer> {
    List<Destination> findByCountry(String name);
}
