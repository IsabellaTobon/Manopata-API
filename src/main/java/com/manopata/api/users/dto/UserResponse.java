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
    private String lastname;
    private String nickname;
    private String email;
//    private String role;

    public UserResponse (User model)
    {
        this.id = model.getId();
        this.name = model.getName();
        this.lastname = model.getLastname();
        this.nickname = model.getNickname();
        this.email = model.getEmail();
    }
}
