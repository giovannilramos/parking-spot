package com.api.parkingcontrol.services;

import com.api.exceptions.AlreadyExistsException;
import com.api.parkingcontrol.integrations.viaCepIntegration.ViaCepIntegration;
import com.api.parkingcontrol.entities.JointOwner;
import com.api.parkingcontrol.helper.JointOwnerHelper;
import com.api.parkingcontrol.repositories.JointOwnerRepository;
import com.api.parkingcontrol.request.JointOwnerRequest;
import com.api.utils.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CreateJointOwnerService {
    private final JointOwnerRepository jointOwnerRepository;
    private final ViaCepIntegration viaCepIntegration;

    @Transactional
    public void save(final JointOwnerRequest jointOwnerRequest) {
        if (jointOwnerRepository.existsByRgOrCpf(jointOwnerRequest.getRg(), jointOwnerRequest.getCpf())) {
            throw new AlreadyExistsException("Conflict: CPF or RG already existent", StatusCode.ALREADY_EXISTS.getStatusCode());
        }

        final var jointOwner = new JointOwner();
        JointOwnerHelper.setJointOwnerEntity(jointOwnerRequest, jointOwner);

        final var jsonNode = viaCepIntegration.getCep(jointOwnerRequest.getCep());

        jointOwner.setStreet(jsonNode.get("logradouro").asText());
        jointOwner.setState(jsonNode.get("uf").asText());
        jointOwner.setDistrict(jsonNode.get("localidade").asText());
        jointOwner.setCity(jsonNode.get("bairro").asText());

        jointOwnerRepository.save(jointOwner);
    }
}
