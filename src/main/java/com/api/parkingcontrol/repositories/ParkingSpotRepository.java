package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.entities.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, UUID> {
    boolean existsByApartmentAndBlockOrLicensePlateCarOrParkingSpotNumber(final String apartment, final String block, final String licensePlateCar, final String parkingSpotNumber);
}
