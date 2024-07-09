package com.manopata.api.posts.interfaces.models;

import com.manopata.api.comments.interfaces.models.Comment;
import com.manopata.api.users.interfaces.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    private String id;
    private String photo;
    private String text;
    private LocalDate registerDate = LocalDate.now();
    private String name;
    private Integer age;
    private String animalType;
    private Boolean vaccinate;
    private String race;
    private Boolean ppp;
    private String city;
    private String province;
    private Boolean available;
    private Integer likes = 0;
    private String userId;
}
