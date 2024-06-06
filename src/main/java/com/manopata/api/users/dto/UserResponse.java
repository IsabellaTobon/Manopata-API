package com.manopata.api.users.dto;

import com.manopata.api.users.interfaces.models.User;


public class UserResponse
{
    private String id;
    private String name;
    private String email;
    private String lastname;
    private String nickname;
    private String rolId;

    public UserResponse (User model)
    {
        this.id = model.getId();
        this.name = model.getName();
        this.email = model.getEmail();
        this.lastname = model.getLastname();
        this.nickname = model.getNickname();
        this.rolId = model.getRol_id();
    }
}
