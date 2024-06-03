package com.manopata.api.comments.interfaces.dbo;

import com.manopata.api.comments.interfaces.models.Comment;
import com.manopata.api.comments.interfaces.repositories.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@Transactional
public class CommentDbo implements CommentRepository {

    @Override
    public Comment post(Comment model) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
