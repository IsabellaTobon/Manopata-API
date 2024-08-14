package com.manopata.api.posts.interfaces.repositories;

import com.manopata.api.posts.interfaces.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaPostRepository extends JpaRepository<Post, String> {
    Optional<Post> findById(String id);

    List<Post> findTop4ByOrderByRegisterDateDesc();

}
