package com.api.parkingcontrol.response;

import lombok.Data;

import java.util.UUID;

@Data
public class JointOwnerResponse {
    private UUID uuid;
    private String name;
    private String cep;
    private String cpf;
    private String rg;
}
