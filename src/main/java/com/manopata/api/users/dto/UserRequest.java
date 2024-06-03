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
    private String rolId;

    public User toModel (String id)
    {
        User model = new User();
        model.setId(id);
        model.setName(this.name);
        model.setLastname(this.lastname);
        model.setNickname(this.nickname);
        model.setRolId(this.rolId);

        return model;
    }
}
