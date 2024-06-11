package com.manopata.api.comments.interfaces.dbo;

import com.manopata.api.comments.interfaces.models.Comment;
import com.manopata.api.comments.interfaces.repositories.CommentRepository;
import com.manopata.api.comments.interfaces.repositories.JpaCommentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
@Transactional
public class CommentDbo implements CommentRepository {
    private final JpaCommentRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public CommentDbo(JpaCommentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Comment save(Comment model) {
        return this.repository.save(model);
    }

    @Override
    public void deleteById(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<Comment> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public Iterable<Comment> findAll() {
        return this.repository.findAll();
    }
}
