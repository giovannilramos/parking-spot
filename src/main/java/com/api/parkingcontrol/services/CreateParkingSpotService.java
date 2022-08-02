package com.api.parkingcontrol.services;

import com.api.exceptions.AlreadyExistsException;
import com.api.parkingcontrol.entities.ParkingSpot;
import com.api.parkingcontrol.helper.ParkingSpotHelper;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.parkingcontrol.request.ParkingSpotRequest;
import com.api.utils.StatusCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class CreateParkingSpotService {
    private final ParkingSpotRepository parkingSpotRepository;

    @Transactional
    public void save(final ParkingSpotRequest parkingSpotRequest) {
        if (parkingSpotRepository.existsByLicensePlateCar(parkingSpotRequest.getLicensePlateCar())) {
            throw new AlreadyExistsException("Conflict: License Plate already exists", StatusCode.ALREADY_EXISTS.getStatusCode());
        }
        if (parkingSpotRepository.existsByApartmentAndBlock(parkingSpotRequest.getApartment(), parkingSpotRequest.getBlock())) {
            throw new AlreadyExistsException("Conflict: Apartment/Block already exists", StatusCode.ALREADY_EXISTS.getStatusCode());
        }
        if (parkingSpotRepository.existsByParkingSpotNumber(parkingSpotRequest.getParkingSpotNumber())) {
            throw new AlreadyExistsException("Conflict: Parking Spot already in use", StatusCode.ALREADY_EXISTS.getStatusCode());
        }

        final var parkingSpot = new ParkingSpot();

        ParkingSpotHelper.setParkingSpotEntity(parkingSpotRequest, parkingSpot);

        parkingSpotRepository.save(parkingSpot);
    }
}
