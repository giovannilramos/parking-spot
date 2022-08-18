package com.api.parkingcontrol.response;

import lombok.Data;

import java.util.UUID;

@Data
public class JointOwnerByIdResponse {
    private UUID uuid;
    private String name;
    private String cpf;
    private String rg;
    private String cep;
    private String complement;
    private String country;
    private String number;
}
