package com.api.parkingcontrol.services;

import com.api.exceptions.NotFoundException;
import com.api.parkingcontrol.helper.ParkingSpotHelper;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.parkingcontrol.request.ParkingSpotRequest;
import com.api.utils.StatusCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UpdateParkingSportService {
    final ParkingSpotRepository parkingSpotRepository;

    public void updateParkingSpot(final UUID id, final ParkingSpotRequest parkingSpotRequest) {
        final var parkingSpotModelOptional = parkingSpotRepository.findById(id);

        if (parkingSpotModelOptional.isEmpty()) {
            throw new NotFoundException("Resource Not Found", StatusCode.NOT_FOUND.getStatusCode());
        }

        final var parkingSpot = parkingSpotModelOptional.get();

        ParkingSpotHelper.setParkingSpotEntity(parkingSpotRequest, parkingSpot);

        parkingSpotRepository.save(parkingSpot);
    }

}
