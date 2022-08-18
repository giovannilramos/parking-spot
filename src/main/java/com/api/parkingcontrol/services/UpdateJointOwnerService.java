package com.api.parkingcontrol.services;

import com.api.exceptions.NotFoundException;
import com.api.parkingcontrol.helper.JointOwnerHelper;
import com.api.parkingcontrol.repositories.JointOwnerRepository;
import com.api.parkingcontrol.request.JointOwnerRequest;
import com.api.utils.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateJointOwnerService {
    private final JointOwnerRepository jointOwnerRepository;

    public void updateJointOwner(final UUID id, final JointOwnerRequest jointOwnerRequest) {
        final var jointOwnerOptional = jointOwnerRepository.findById(id);

        if (jointOwnerOptional.isEmpty()) {
            throw new NotFoundException("Resource Not Found", StatusCode.NOT_FOUND.getStatusCode());
        }

        final var jointOwner = jointOwnerOptional.get();

        JointOwnerHelper.setJointOwnerEntity(jointOwnerRequest, jointOwner);

        jointOwnerRepository.save(jointOwner);
    }

}
