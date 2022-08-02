package com.api.parkingcontrol.helper;

import com.api.parkingcontrol.entities.ParkingSpot;
import com.api.parkingcontrol.request.ParkingSpotRequest;
import com.api.parkingcontrol.response.ParkingSpotByIdResponse;
import com.api.parkingcontrol.response.ParkingSpotResponse;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class ParkingSpotHelper {
    public static void parkingSpotByIdSetResponse(final ParkingSpotByIdResponse parkingSpotByIdResponse, final ParkingSpot parkingSpot) {
        parkingSpotByIdResponse.setUuid(parkingSpot.getUuid());
        parkingSpotByIdResponse.setRegistrationDate(parkingSpot.getRegistrationDate());
        parkingSpotByIdResponse.setParkingSpotNumber(parkingSpot.getParkingSpotNumber());
        parkingSpotByIdResponse.setLicensePlateCar(parkingSpot.getLicensePlateCar());
        parkingSpotByIdResponse.setBrandCar(parkingSpot.getBrandCar());
        parkingSpotByIdResponse.setModelCar(parkingSpot.getModelCar());
        parkingSpotByIdResponse.setColorCar(parkingSpot.getColorCar());
        parkingSpotByIdResponse.setResponsibleName(parkingSpot.getResponsibleName());
        parkingSpotByIdResponse.setApartment(parkingSpot.getApartment());
        parkingSpotByIdResponse.setBlock(parkingSpot.getBlock());
    }

    public static void parkingSpotSetResponse(final ParkingSpotResponse parkingSpotResponse, final ParkingSpot parkingSpot) {
        parkingSpotResponse.setUuid(parkingSpot.getUuid());
        parkingSpotResponse.setRegistrationDate(parkingSpot.getRegistrationDate());
        parkingSpotResponse.setParkingSpotNumber(parkingSpot.getParkingSpotNumber());
        parkingSpotResponse.setLicensePlateCar(parkingSpot.getLicensePlateCar());
        parkingSpotResponse.setResponsibleName(parkingSpot.getResponsibleName());
        parkingSpotResponse.setApartment(parkingSpot.getApartment());
        parkingSpotResponse.setBlock(parkingSpot.getBlock());
    }

    public static void setParkingSpotEntity(final ParkingSpotRequest parkingSpotRequest, final ParkingSpot parkingSpot) {
        parkingSpot.setRegistrationDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        parkingSpot.setParkingSpotNumber(parkingSpotRequest.getParkingSpotNumber());
        parkingSpot.setLicensePlateCar(parkingSpotRequest.getLicensePlateCar());
        parkingSpot.setBrandCar(parkingSpotRequest.getBrandCar());
        parkingSpot.setModelCar(parkingSpotRequest.getModelCar());
        parkingSpot.setColorCar(parkingSpotRequest.getColorCar());
        parkingSpot.setResponsibleName(parkingSpotRequest.getResponsibleName());
        parkingSpot.setApartment(parkingSpotRequest.getApartment());
        parkingSpot.setBlock(parkingSpotRequest.getBlock());
    }
}
