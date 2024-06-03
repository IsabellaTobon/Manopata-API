package com.manopata.api.posts.interfaces.repositories;

import com.manopata.api.posts.interfaces.models.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save (Post model);
    void delete (String id);
    Optional<Post> findById(String id);
    Optional<Post> findByAnimalType(String animalType);
    Optional<Post> findByRace(String race);
    Optional<Post> findByPpp(Boolean ppp);
    Optional<Post> findByCity(String city);
    Optional<Post> findByProvince(String province);
    Optional<Post> findByAvailable(Boolean available);
    List<Post> findByUserId(String userId);



}
