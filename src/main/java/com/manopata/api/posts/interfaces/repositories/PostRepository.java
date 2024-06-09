package com.manopata.api.posts.interfaces.repositories;

import com.manopata.api.posts.interfaces.models.Post;
import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post model);
    Post edit(Post model);
    void delete(String id);
    Optional<Post> findById(String id);
    List<Post> findAll();

}
