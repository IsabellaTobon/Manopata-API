package com.manopata.api.roles.interfaces.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roleendpoint")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleEndpoint
{
    @Id
    private String id;
    private String role;
    private String request;
    private boolean enabled;
}
