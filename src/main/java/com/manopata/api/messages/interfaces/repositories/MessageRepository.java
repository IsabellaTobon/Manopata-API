package com.manopata.api.messages.interfaces.repositories;

import com.manopata.api.messages.interfaces.models.Message;

import java.util.List;
import java.util.Optional;

public interface MessageRepository {
    Message save(Message model);
    void delete(String id);
    Optional<Message> findById(String id);
    List<Message> findByPostId(String postId);
    List<Message> findByReceiverId(String receiverId);
}
