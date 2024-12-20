package com.manopata.api.users.interfaces.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;
    private String name;
    private String lastname;
    private String email;
    private String nickname;
    private String password;
    private String role;

}
