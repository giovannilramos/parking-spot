package com.api.parkingcontrol.helper;

import com.api.parkingcontrol.entities.JointOwner;
import com.api.parkingcontrol.request.JointOwnerRequest;
import com.api.parkingcontrol.response.JointOwnerByIdResponse;
import com.api.parkingcontrol.response.JointOwnerResponse;


import java.util.Objects;

public class JointOwnerHelper {
    public static void jointOwnerIdSetResponse(final JointOwnerByIdResponse jointOwnerByIdResponse, final JointOwner jointOwner) {
        jointOwnerByIdResponse.setUuid(jointOwner.getUuid());
        jointOwnerByIdResponse.setCep(jointOwner.getCep());
        jointOwnerByIdResponse.setName(jointOwner.getName());
        jointOwnerByIdResponse.setCpf(jointOwner.getCpf());
        jointOwnerByIdResponse.setRg(jointOwner.getRg());
        jointOwnerByIdResponse.setComplement(jointOwner.getComplement());
        jointOwnerByIdResponse.setCountry(jointOwner.getCountry());
        jointOwnerByIdResponse.setNumber(jointOwner.getNumber());
    }

    public static void jointOwnerSetResponse(final JointOwnerResponse jointOwnerResponse, final JointOwner jointOwner) {
        jointOwnerResponse.setUuid(jointOwner.getUuid());
        jointOwnerResponse.setCep(jointOwner.getCep());
        jointOwnerResponse.setName(jointOwner.getName());
        jointOwnerResponse.setCpf(jointOwner.getCpf());
        jointOwnerResponse.setRg(jointOwner.getRg());
    }

    public static void setJointOwnerEntity(final JointOwnerRequest jointOwnerRequest, final JointOwner jointOwner) {
        jointOwner.setCep(jointOwnerRequest.getCep());
        jointOwner.setCountry(jointOwnerRequest.getCountry());
        jointOwner.setCpf(jointOwnerRequest.getCpf());
        jointOwner.setName(jointOwnerRequest.getName());
        jointOwner.setNumber(jointOwnerRequest.getNumber());
        jointOwner.setRg(jointOwnerRequest.getRg());
        if (Objects.nonNull(jointOwnerRequest.getComplement()) && !jointOwnerRequest.getComplement().isEmpty()) {
            jointOwner.setComplement(jointOwnerRequest.getComplement());
        }
    }
}
