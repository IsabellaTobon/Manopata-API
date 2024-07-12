package com.manopata.api.protectors.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "protectors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Protector {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String description;
    private String phone;
    private String email;

}
