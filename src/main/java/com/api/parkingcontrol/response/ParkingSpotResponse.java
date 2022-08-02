package com.api.parkingcontrol.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ParkingSpotResponse {
    private UUID uuid;
    private String parkingSpotNumber;
    private String licensePlateCar;
    private LocalDateTime registrationDate;
    private String responsibleName;
    private String apartment;
    private String block;
}
