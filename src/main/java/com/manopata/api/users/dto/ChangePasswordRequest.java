package com.manopata.api.users.dto;

import lombok.Data;

@Data
public class ChangePasswordRequest {
    private String nickname;
    private String currentPassword;
    private String newPassword;
}
