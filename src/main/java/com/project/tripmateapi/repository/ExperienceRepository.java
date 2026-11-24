package com.project.tripmateapi.repository;

import com.project.tripmateapi.enums.ActivityType;
import com.project.tripmateapi.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    List<Experience> findByActivity(ActivityType activity);

    Experience findTopByTripIdOrderByRatingDesc(Integer tripId);
}
