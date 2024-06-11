package com.manopata.api.comments.services;

import com.manopata.api.comments.interfaces.models.Comment;
import com.manopata.api.comments.interfaces.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Optional<Comment> findById(String id) {
        return commentRepository.findById(id);
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteById(String id) {
        commentRepository.deleteById(id);
    }
}
