package com.manopata.api.roles.dto;

import com.manopata.api.roles.interfaces.models.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolRequest
{

    private String rol;
    private String description;

    public Rol toModel(String id)
    {
        Rol model = new Rol();
        model.setRol(rol);
        model.setDescription(this.description);

        return model;
    }
}
