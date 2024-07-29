package com.manopata.api.messages.interfaces.dbo;

import com.manopata.api.messages.interfaces.models.Message;
import com.manopata.api.messages.interfaces.repositories.JpaMessageRepository;
import com.manopata.api.messages.interfaces.repositories.MessageRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //No estoy segura
public class MessageDbo implements MessageRepository {
    private JpaMessageRepository repository;

    @PersistenceContext
    public EntityManager entityManager;

    public MessageDbo(JpaMessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public Message save(Message model) {
        return this.repository.save(model);
    }

    @Override
    public void delete(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<Message> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public List<Message> findByPostId(String postId) {
        return this.repository.findByPostId(postId);
    }

    @Override
    public List<Message> findByReceiverId(String receiverId) {
        return this.repository.findByReceiverId(receiverId);
    }
}
