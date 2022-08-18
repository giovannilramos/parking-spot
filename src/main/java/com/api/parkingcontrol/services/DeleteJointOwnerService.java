package com.api.parkingcontrol.services;

import com.api.exceptions.NotFoundException;
import com.api.parkingcontrol.repositories.JointOwnerRepository;
import com.api.utils.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteJointOwnerService {
    private final JointOwnerRepository jointOwnerRepository;

    @Transactional
    public void deleteJointOwner(final UUID uuid) {
        final var jointOwnerOptional = jointOwnerRepository.findById(uuid);
        if (jointOwnerOptional.isEmpty()) {
            throw new NotFoundException("Resource Not Found", StatusCode.NOT_FOUND.getStatusCode());
        }
        jointOwnerRepository.delete(jointOwnerOptional.get());
    }
}
