package com.api.parkingcontrol.controller;

import com.api.parkingcontrol.request.JointOwnerRequest;
import com.api.parkingcontrol.response.JointOwnerByIdResponse;
import com.api.parkingcontrol.response.JointOwnerResponse;
import com.api.parkingcontrol.services.*;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/joint-owner")
@RequiredArgsConstructor
public class JointOwnerController {
    private final CreateJointOwnerService createJointOwnerService;
    private final GetByIdJointOwnerService getByIdJointOwnerService;
    private final ListJointOwnerService listJointOwnerService;
    private final UpdateJointOwnerService updateJointOwnerService;
    private final DeleteJointOwnerService deleteJointOwnerService;

    @PostMapping
    public ResponseEntity<Void> saveParkingSpot(@RequestBody @Valid final JointOwnerRequest jointOwnerRequest) {
        createJointOwnerService.save(jointOwnerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<JointOwnerResponse>> getAllParkingSpot(@PageableDefault(sort = "uuid", direction = Sort.Direction.DESC) final Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(listJointOwnerService.getAllJointOwner(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JointOwnerByIdResponse> getParkingSpot(@PathVariable(value = "id") final UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(getByIdJointOwnerService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParkingSpot(@PathVariable(value = "id") final UUID id) {
        deleteJointOwnerService.deleteJointOwner(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateParkingSpot(@PathVariable(value = "id") final UUID id, @RequestBody final JointOwnerRequest jointOwnerRequest) {
        updateJointOwnerService.updateJointOwner(id, jointOwnerRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
