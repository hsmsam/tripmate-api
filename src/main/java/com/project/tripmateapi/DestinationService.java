package com.project.tripmateapi;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {
    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    public Destination getDestinationById(Integer id) {
        return destinationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Destination doesn't exist"));
    }

    public List<Destination> getDestinationByCountry(String name) {
        return destinationRepository.findByCountry(name);
    }

    public void addANewDestination(Destination destination) {
        destinationRepository.save(destination);
    }

    public void updateDestinationDetails(Integer id, Destination destination) {
        Destination destinationExist = destinationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Destination not found"));

        if (destination.getCountry() != null) {
            destinationExist.setCountry(destination.getCountry());
        }

        if (destination.getCity() != null) {
            destinationExist.setCity(destination.getCity());
        }

        if (destination.getDescription() != null) {
            destinationExist.setDescription(destination.getDescription());
        }

        destinationRepository.save(destinationExist);
    }

    public void removeADestination(Integer id) {
        destinationRepository.deleteById(id);
    }
}
