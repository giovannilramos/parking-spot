package com.api.parkingcontrol.services;

import com.api.exceptions.NotFoundException;
import com.api.parkingcontrol.helper.JointOwnerHelper;
import com.api.parkingcontrol.repositories.JointOwnerRepository;
import com.api.parkingcontrol.response.JointOwnerByIdResponse;
import com.api.utils.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetByIdJointOwnerService {
    private final JointOwnerRepository jointOwnerRepository;

    public JointOwnerByIdResponse findById(final UUID id) {
        final var jointOwnerOptional = jointOwnerRepository.findById(id);
        if (jointOwnerOptional.isEmpty()) {
            throw new NotFoundException("Resource not found", StatusCode.NOT_FOUND.getStatusCode());
        }
        final var jointOwnerByIdResponse = new JointOwnerByIdResponse();
        final var jointOwner = jointOwnerOptional.get();

        JointOwnerHelper.jointOwnerIdSetResponse(jointOwnerByIdResponse, jointOwner);
        return jointOwnerByIdResponse;
    }
}
