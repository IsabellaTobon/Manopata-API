package com.manopata.api.posts.interfaces.dbo;

import com.manopata.api.posts.interfaces.models.Post;
import com.manopata.api.posts.interfaces.repositories.JpaPostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

public class PostDbo implements PostRepository {
    private JpaPostRepository repository;

    @PersistenceContext
    public EntityManager entityManager;

    public PostDbo(JpaPostRepository repository) {
        this.repository = repository;
    }

    @Override
    public Post save(Post model) {
        return this.repository.save(model);
    }

    @Override
    public Post edit(Post model) {
        return null;
    }

    @Override
    public void delete(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<Post> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public List<Post> findAll() {
        return this.repository.findAll();
    }
}
