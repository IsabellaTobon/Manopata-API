package com.manopata.api.roles.dto;

import com.manopata.api.roles.interfaces.models.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolResponse
{

    private String rol;
    private String description;

    public RolResponse (Rol model)
    {
        this.rol = model.getRol();
        this.description = model.getDescription();
    }
}
