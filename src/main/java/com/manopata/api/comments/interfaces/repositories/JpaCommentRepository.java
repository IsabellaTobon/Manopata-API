package com.manopata.api.comments.interfaces.repositories;

import com.manopata.api.comments.interfaces.models.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCommentRepository {
    Comment post(Comment model);
    void delete (String id);
}
