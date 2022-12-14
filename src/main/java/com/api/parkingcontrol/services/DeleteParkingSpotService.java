package com.api.parkingcontrol.services;

import com.api.exceptions.NotFoundException;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.utils.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteParkingSpotService {
    private final ParkingSpotRepository parkingSpotRepository;

    @Transactional
    public void deleteParkingSpot(final UUID uuid) {
        final var parkingSpotOptional = parkingSpotRepository.findById(uuid);
        if (parkingSpotOptional.isEmpty()) {
            throw new NotFoundException("Resource Not Found", StatusCode.NOT_FOUND.getStatusCode());
        }
        parkingSpotRepository.delete(parkingSpotOptional.get());
    }
}
