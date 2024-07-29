package com.manopata.api.messages.services;

import com.manopata.api.messages.interfaces.models.Message;
import com.manopata.api.messages.interfaces.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Message sendMessage(Message message) {
        message.setId(UUID.randomUUID().toString());
        return messageRepository.save(message);
    }

    public List<Message> getMessagesForPost(String postId) {
        return messageRepository.findByPostId(postId);
    }

    public List<Message> getMessagesForUser(String userId) {
        return messageRepository.findByReceiverId(userId);
    }

}
