package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.entities.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, UUID> {
    boolean existsByLicensePlateCar(final String licensePlateCar);
    boolean existsByApartmentAndBlock(final String apartment, final String block);
    boolean existsByParkingSpotNumber(final String parkingSpotNumber);
}
