package com.manopata.api.users.dto;

import com.manopata.api.users.interfaces.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse
{
    private String id;
    private String name;
    private String email;
    private String lastname;
    private String nickname;
    private String role;

    public UserResponse (User model)
    {
        this.id = model.getId();
        this.name = model.getName();
        this.email = model.getEmail();
        this.lastname = model.getLastname();
        this.nickname = model.getNickname();
        this.role = model.getRole();
    }
}
