package com.manopata.api.messages.interfaces.repositories;

import com.manopata.api.messages.interfaces.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaMessageRepository extends JpaRepository <Message, String> {
    List<Message> findByPostId(String postId);
    List<Message> findByReceiverId(String receiverId);
}
