package com.manopata.api.auth.dto;

import lombok.Data;

@Data
public class LoginRequest
{
    private String nickname;
    private String password;
}
