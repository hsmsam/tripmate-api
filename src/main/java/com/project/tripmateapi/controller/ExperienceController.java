package com.project.tripmateapi.controller;

import com.project.tripmateapi.enums.ActivityType;
import com.project.tripmateapi.entity.Experience;
import com.project.tripmateapi.service.ExperienceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/experience")
public class ExperienceController {
    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping
    public List<Experience> getAllExperiences() {
        return experienceService.getAllExperiences();
    }

    @GetMapping("{id}")
    public Experience getExperienceById(@PathVariable Integer id) {
        return experienceService.getExperienceById(id);
    }

    @GetMapping("/type/{type}")
    public List<Experience> getExperienceByActivityType(@PathVariable ActivityType type) {
        return experienceService.getExperienceByActivityType(type);
    }

    @GetMapping("/trip/{tripId}/top-rated")
    public Experience getHighestRatedExperience(@PathVariable Integer tripId) {
        return experienceService.getHighestRatedExperience(tripId);
    }

    @PostMapping
    public void addAExperience(@RequestBody Experience experience) {
        experienceService.addAExperience(experience);
    }

    @PutMapping("{id}")
    public Experience updateAExperience(@PathVariable Integer id, @RequestBody Experience experience) {
        return experienceService.updateAExperience(id, experience);
    }

    @DeleteMapping("{id}")
    public void deleteAExperience(@PathVariable Integer id) {
        experienceService.deleteAExperience(id);
    }
}
