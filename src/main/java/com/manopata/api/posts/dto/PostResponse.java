package com.manopata.api.posts.dto;

import com.manopata.api.posts.interfaces.models.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse
{
    private String id;
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

    public PostResponse (Post model)
    {
       this.id = model.getId();
       this.photo = model.getPhoto();
       this.registerDate = model.getRegisterDate();
       this.name = model.getName();
       this.age = model.getAge();
       this.animalType = model.getAnimalType();
       this.vaccinate = model.getVaccinate();
       this.race = model.getRace();
       this.ppp = model.getPpp();
       this.city = model.getCity();
       this.province = model.getProvince();
       this.available = model.getAvailable();
       this.likes = model.getLikes();
       this.userId = model.getUserId();
    }
}
