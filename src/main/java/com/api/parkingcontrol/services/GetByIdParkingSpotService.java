package com.api.parkingcontrol.services;

import com.api.exceptions.NotFoundException;
import com.api.parkingcontrol.helper.ParkingSpotHelper;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.parkingcontrol.response.ParkingSpotByIdResponse;
import com.api.utils.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetByIdParkingSpotService {
    private final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotByIdResponse findById(final UUID id) {
        final var parkingSpotOptional = parkingSpotRepository.findById(id);
        if (parkingSpotOptional.isEmpty()) {
            throw new NotFoundException("Resource not found", StatusCode.NOT_FOUND.getStatusCode());
        }
        final var parkingSpotByIdResponse = new ParkingSpotByIdResponse();
        final var parkingSpot = parkingSpotOptional.get();

        ParkingSpotHelper.parkingSpotByIdSetResponse(parkingSpotByIdResponse, parkingSpot);
        return parkingSpotByIdResponse;
    }
}
