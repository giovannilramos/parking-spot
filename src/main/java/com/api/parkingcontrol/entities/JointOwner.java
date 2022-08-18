package com.api.parkingcontrol.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@Data
@Table(name = "TB_JOINT_OWNER")
public class JointOwner {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String rg;

    @Column(nullable = false, length = 8)
    private String cep;

    @Column(nullable = false)
    private String street;

    private String complement;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false, length = 2)
    private String state;

    @Column(nullable = false, length = 2)
    private String country;

    @Column(nullable = false)
    private String number;

}
