package com.manopata.api.users.dto;

import com.manopata.api.users.interfaces.models.User;
import lombok.Data;

@Data
public class UpdateUserRequest {
    private String name;
    private String lastname;
    private String nickname;
    private String email;
    private String currentPassword;

    public void updateModel (User model)
    {
        model.setName(this.name);
        model.setLastname(this.lastname);
        model.setNickname(this.nickname);
        model.setEmail(this.email);
    }
}
