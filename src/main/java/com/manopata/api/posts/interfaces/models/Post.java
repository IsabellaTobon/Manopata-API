package com.manopata.api.posts.interfaces.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    private String id;
    private String photo;
    private Date registerDate;
    private String name;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private AnimalType animalType;
    private Boolean vaccinate;
    private String race;
    private Boolean ppp;
    private String city;
    private String province;
    private Boolean available;
    private Integer likes;
    private String userId;


}
