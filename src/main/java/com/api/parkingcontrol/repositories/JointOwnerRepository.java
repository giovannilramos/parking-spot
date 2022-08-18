package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.entities.JointOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JointOwnerRepository extends JpaRepository<JointOwner, UUID> {
    boolean existsByRgOrCpf(final String rg, final String cpf);
}
