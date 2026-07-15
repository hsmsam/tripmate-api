package com.project.tripmateapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, Integer> {
    Destination getByCountry(String country);
}
