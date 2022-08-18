package com.api.parkingcontrol.services;

import com.api.parkingcontrol.helper.JointOwnerHelper;
import com.api.parkingcontrol.repositories.JointOwnerRepository;
import com.api.parkingcontrol.response.JointOwnerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListJointOwnerService {
    private final JointOwnerRepository jointOwnerRepository;

    public List<JointOwnerResponse> getAllJointOwner(final Pageable pageable) {
        final var jointOwnerList = jointOwnerRepository.findAll(pageable);
        return jointOwnerList.stream().map(el -> {
            final var jointOwnerResponse = new JointOwnerResponse();
            JointOwnerHelper.jointOwnerSetResponse(jointOwnerResponse, el);
            return jointOwnerResponse;
        }).collect(Collectors.toList());
    }
}
