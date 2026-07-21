package com.project.tripmateapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tripmate-api/destination")
public class DestinationController {
    DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping
    public List<Destination> getAllDestinations() {
        return destinationService.getAllDestinations();
    }

    @GetMapping("/{id}")
    public Destination getDestinationById(@PathVariable Integer id) {
        return destinationService.getDestinationById(id);
    }

    @GetMapping("/country/{country}")
    public Destination getDestinationByCountry(@PathVariable String country) {
        return destinationService.getDestinationByCountry(country);
    }

    @PutMapping("{id}")
    public void updateDestinationDetails(@PathVariable Integer id, @RequestBody Destination destination) {
        destinationService.updateDestinationDetails(id, destination);
    }

    @PostMapping
    public void addANewDestination(@RequestBody Destination destination) {
        destinationService.addANewDestination(destination);
    }

    @DeleteMapping("{id}")
    public void removeADestination(@PathVariable Integer id) {
        destinationService.removeADestination(id);
    }
}
