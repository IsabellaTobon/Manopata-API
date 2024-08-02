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
    private String lastname;
    private String nickname;
    private String email;
    private String password;
    private String role;

    public User toModel (String id, String encodedPassword, String role)

    {
        User model = new User();
        model.setId(id);
        model.setName(this.name);
        model.setLastname(this.lastname);
        model.setNickname(this.nickname);
        model.setEmail(this.email);
        model.setPassword(encodedPassword); //password codificated
        model.setRole(role); // Use the method parameter instead of this.role

        return model;
    }

}
