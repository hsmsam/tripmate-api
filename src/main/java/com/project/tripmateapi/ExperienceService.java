package com.project.tripmateapi;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {
    private final ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    public Experience getExperienceById(Integer id) {
        return experienceRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + " not found"));
    }

    public List<Experience> getExperienceByActivityType(ActivityType activity) {
        return experienceRepository.findByActivity(activity);
    }

    public Experience getHighestRatedExperience(Integer id) {
        return experienceRepository.findTopByTripIdOrderByRatingDesc(id);
    }

    public void addAExperience(Experience experience) {
        experienceRepository.save(experience);
    }

    public Experience updateAExperience(Integer id, Experience experience) {
        Experience experienceExists = experienceRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("No experience found"));

        if (experience.getTrip() != null) {
            experienceExists.setTrip(experience.getTrip());
        }

        if (experience.getTitle() != null) {
            experienceExists.setTitle(experience.getTitle());
        }

        if (experience.getActivity() != null) {
            experienceExists.setActivity(experience.getActivity());
        }

        if (experience.getPrice() != null) {
            experienceExists.setPrice(experience.getPrice());
        }

        if (experience.getRating() != null) {
            experienceExists.setRating(experience.getRating());
        }

        if (experience.getReview() != null) {
            experienceExists.setReview(experience.getReview());
        }

        return experienceRepository.save(experienceExists);
    }

    public void deleteAExperience(Integer id) {
        experienceRepository.deleteById(id);
    }
}
