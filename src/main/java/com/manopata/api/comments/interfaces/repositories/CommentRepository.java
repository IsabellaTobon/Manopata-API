package com.manopata.api.comments.interfaces.repositories;

import com.manopata.api.comments.interfaces.models.Comment;

import java.util.Optional;

public interface CommentRepository {

    Comment save(Comment model);
    void deleteById(String id);
    Optional<Comment> findById(String id);
    Iterable<Comment> findAll();
}
