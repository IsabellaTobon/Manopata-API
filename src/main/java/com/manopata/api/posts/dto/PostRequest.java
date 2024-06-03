package com.manopata.api.posts.dto;

import com.manopata.api.posts.interfaces.models.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PostRequest
{

    private String photo;
    private Date registerDate;
    private String name;
    private Integer age;
    private String animalType;
    private Boolean vaccinate;
    private String race;
    private Boolean ppp;
    private String city;
    private String province;
    private Boolean available;
    private Integer likes;
    private String userId;

    public Post toModel (String id)
    {
        Post model = new Post();
        model.setId(id);
        model.setPhoto(this.photo);
        model.setRegisterDate(this.registerDate);
        model.setName(this.name);
        model.setAge(this.age);
        model.setAnimalType(this.animalType);
        model.setVaccinate(this.vaccinate);
        model.setRace(this.race);
        model.setPpp(this.ppp);
        model.setCity(this.city);
        model.setProvince(this.province);
        model.setAvailable(this.available);
        model.setLikes(this.likes);
        model.setUserId(this.userId);

        return model;
    }
}
