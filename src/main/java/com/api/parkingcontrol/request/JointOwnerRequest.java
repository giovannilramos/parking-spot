package com.api.parkingcontrol.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class JointOwnerRequest {
    @NotBlank
    private String name;
    @NotBlank
    @Size(max = 11, message = "The CPF must contain only 11 numbers")
    private String cpf;
    @NotBlank
    private String rg;
    @NotBlank
    @Size(max = 8, message = "The CEP must contain only 8 numbers")
    private String cep;
    private String complement;
    @NotBlank
    @Size(max = 2, message = "The country must contain only 2 letters")
    private String country;
    @NotBlank
    private String number;
}
