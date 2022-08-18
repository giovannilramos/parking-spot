package com.api.parkingcontrol.services;

import com.api.exceptions.AlreadyExistsException;
import com.api.parkingcontrol.entities.ParkingSpot;
import com.api.parkingcontrol.helper.ParkingSpotHelper;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.parkingcontrol.request.ParkingSpotRequest;
import com.api.utils.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CreateParkingSpotService {
    private final ParkingSpotRepository parkingSpotRepository;

    @Transactional
    public void save(final ParkingSpotRequest parkingSpotRequest) {
        if (parkingSpotRepository.existsByApartmentAndBlockOrLicensePlateCarOrParkingSpotNumber(parkingSpotRequest.getApartment(), parkingSpotRequest.getBlock(), parkingSpotRequest.getLicensePlateCar(), parkingSpotRequest.getParkingSpotNumber())) {
            throw new AlreadyExistsException("Conflict: Apartment and Block/License Plate/Parking Spot number already exists", StatusCode.ALREADY_EXISTS.getStatusCode());
        }

        final var parkingSpot = new ParkingSpot();

        ParkingSpotHelper.setParkingSpotEntity(parkingSpotRequest, parkingSpot);

        parkingSpotRepository.save(parkingSpot);
    }
}
