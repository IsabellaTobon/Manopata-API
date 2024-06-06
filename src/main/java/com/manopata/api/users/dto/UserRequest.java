package com.manopata.api.users.dto;

import com.manopata.api.users.interfaces.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest
{
    private String name;
    private String email;
    private String lastname;
    private String nickname;
    private String user_password;
    private String rol_id;

    public User toModel (String id)
    {
        User model = new User();
        model.setId(id);
        model.setName(this.name);
        model.setEmail(this.email);
        model.setLastname(this.lastname);
        model.setNickname(this.nickname);
        model.setUser_password(this.user_password);
        model.setRol_id(this.rol_id);

        return model;
    }
}
