package com.manopata.api.users.dto;

import com.manopata.api.roles.interfaces.models.Role;
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
    private String password;
    private String roleName;

    public User toModel (String id, Role role)
    {
        User model = new User();
        model.setId(id);
        model.setName(this.name);
        model.setEmail(this.email);
        model.setLastname(this.lastname);
        model.setNickname(this.nickname);
        model.setPassword(this.password);
        model.setRole(role.getName());

        return model;
    }
}
