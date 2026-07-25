package com.project.tripmateapi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    List<Experience> findByActivity(ActivityType activity);

    Experience findTopByTripIdOrderByRatingDesc(Integer tripId);
}
