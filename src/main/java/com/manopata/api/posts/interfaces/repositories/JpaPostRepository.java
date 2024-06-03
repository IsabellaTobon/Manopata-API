package com.manopata.api.posts.interfaces.repositories;

import com.manopata.api.posts.interfaces.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaPostRepository extends JpaRepository <Post, String> {
    Optional<Post> findByAnimalType(String animalType);
    Optional<Post> findByRace(String race);
    Optional<Post> findByPpp(Boolean ppp);
    Optional<Post> findByCity(String city);
    Optional<Post> findByProvince(String province);
    Optional<Post> findByAvailable(Boolean available);
    Optional<Post> findByUserId(String userId);

}
