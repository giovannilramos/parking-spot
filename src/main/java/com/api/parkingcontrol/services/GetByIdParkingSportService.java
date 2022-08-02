package com.api.parkingcontrol.services;

import com.api.exceptions.NotFoundException;
import com.api.parkingcontrol.helper.ParkingSpotHelper;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.parkingcontrol.response.ParkingSpotByIdResponse;
import com.api.utils.StatusCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class GetByIdParkingSportService {
    private final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotByIdResponse findById(final UUID id) {
        final var parkingSpotModelOptional = parkingSpotRepository.findById(id);
        if (parkingSpotModelOptional.isEmpty()) {
            throw new NotFoundException("Resource not found", StatusCode.NOT_FOUND.getStatusCode());
        }
        final var parkingSpotByIdResponse = new ParkingSpotByIdResponse();
        final var parkingSpot = parkingSpotModelOptional.get();

        ParkingSpotHelper.parkingSpotByIdSetResponse(parkingSpotByIdResponse, parkingSpot);
        return parkingSpotByIdResponse;
    }
}
