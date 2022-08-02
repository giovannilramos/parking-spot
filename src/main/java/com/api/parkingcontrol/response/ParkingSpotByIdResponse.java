package com.api.parkingcontrol.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ParkingSpotByIdResponse {
    private UUID uuid;
    private String parkingSpotNumber;
    private String licensePlateCar;
    private String brandCar;
    private String modelCar;
    private String colorCar;
    private LocalDateTime registrationDate;
    private String responsibleName;
    private String apartment;
    private String block;
}
