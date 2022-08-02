package com.api.parkingcontrol.services;

import com.api.exceptions.NotFoundException;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.utils.StatusCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DeleteParkingSpotService {
    private final ParkingSpotRepository parkingSpotRepository;

    @Transactional
    public void deleteParkingSpot(final UUID uuid) {
        final var parkingSpotModelOptional = parkingSpotRepository.findById(uuid);
        if (parkingSpotModelOptional.isEmpty()) {
            throw new NotFoundException("Resource Not Found", StatusCode.NOT_FOUND.getStatusCode());
        }
        parkingSpotRepository.delete(parkingSpotModelOptional.get());
    }
}
