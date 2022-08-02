package com.api.parkingcontrol.controller;

import com.api.parkingcontrol.request.ParkingSpotRequest;
import com.api.parkingcontrol.response.ParkingSpotByIdResponse;
import com.api.parkingcontrol.response.ParkingSpotResponse;
import com.api.parkingcontrol.services.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
@AllArgsConstructor
public class ParkingSpotController {
    private final CreateParkingSpotService createParkingSpotService;
    private final ListParkingSpotService listParkingSpotService;
    private final GetByIdParkingSpotService getByIdParkingSpotService;
    private final UpdateParkingSpotService updateParkingSpotService;
    private final DeleteParkingSpotService deleteParkingSpotService;


    @PostMapping
    public ResponseEntity<Void> saveParkingSpot(@RequestBody @Valid final ParkingSpotRequest parkingSpotRequest) {
        createParkingSpotService.save(parkingSpotRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpotResponse>> getAllParkingSpot(@PageableDefault(sort = "uuid", direction = Sort.Direction.DESC) final Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(listParkingSpotService.getAllParkingSpot(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpotByIdResponse> getParkingSpot(@PathVariable(value = "id") final UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(getByIdParkingSpotService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParkingSpot(@PathVariable(value = "id") final UUID id) {
        deleteParkingSpotService.deleteParkingSpot(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateParkingSpot(@PathVariable(value = "id") final UUID id, @RequestBody final ParkingSpotRequest parkingSpotRequest) {
        updateParkingSpotService.updateParkingSpot(id, parkingSpotRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
