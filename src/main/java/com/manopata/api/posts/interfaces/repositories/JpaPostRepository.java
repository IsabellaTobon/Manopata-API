package com.manopata.api.posts.interfaces.repositories;

import com.manopata.api.posts.interfaces.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaPostRepository extends JpaRepository<Post, String> {
    Optional<Post> findById(String id);

    @Query("SELECT p FROM Post p ORDER BY p.registerDate DESC")
    List<Post> findTop4ByOrderByRegisterDateDesc();

}
