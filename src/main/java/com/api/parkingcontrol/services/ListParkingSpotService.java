package com.api.parkingcontrol.services;

import com.api.parkingcontrol.helper.ParkingSpotHelper;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.parkingcontrol.response.ParkingSpotResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListParkingSpotService {
    private final ParkingSpotRepository parkingSpotRepository;

    public List<ParkingSpotResponse> getAllParkingSpot(final Pageable pageable) {
        final var parkingSpotList = parkingSpotRepository.findAll(pageable);
        return parkingSpotList.stream().map(el -> {
            final var parkingSpotResponse = new ParkingSpotResponse();
            ParkingSpotHelper.parkingSpotSetResponse(parkingSpotResponse, el);
            return parkingSpotResponse;
        }).collect(Collectors.toList());
    }
}
