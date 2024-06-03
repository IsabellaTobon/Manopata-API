package com.manopata.api.comments.interfaces.repositories;

import com.manopata.api.comments.interfaces.models.Comment;

public interface CommentRepository {

    Comment post(Comment model);
    void delete (String id);

}
