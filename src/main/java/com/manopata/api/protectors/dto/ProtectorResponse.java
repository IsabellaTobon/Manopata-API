package com.manopata.api.protectors.dto;

import lombok.Data;

@Data
public class ProtectorResponse {
    private String id;
    private String name;
    private String description;
    private String phone;
    private String email;
}
