package com.api.parkingcontrol.services;

import com.api.exceptions.NotFoundException;
import com.api.parkingcontrol.helper.ParkingSpotHelper;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.parkingcontrol.request.ParkingSpotRequest;
import com.api.utils.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateParkingSpotService {
    private final ParkingSpotRepository parkingSpotRepository;

    public void updateParkingSpot(final UUID id, final ParkingSpotRequest parkingSpotRequest) {
        final var parkingSpotOptional = parkingSpotRepository.findById(id);

        if (parkingSpotOptional.isEmpty()) {
            throw new NotFoundException("Resource Not Found", StatusCode.NOT_FOUND.getStatusCode());
        }

        final var parkingSpot = parkingSpotOptional.get();

        ParkingSpotHelper.setParkingSpotEntity(parkingSpotRequest, parkingSpot);

        parkingSpotRepository.save(parkingSpot);
    }

}
