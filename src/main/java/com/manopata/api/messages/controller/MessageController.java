package com.manopata.api.messages.controller;

import com.manopata.api.messages.interfaces.models.Message;
import com.manopata.api.messages.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping
    public Message sendMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }

    @GetMapping("/post/{postId}")
    public List<Message> getMessagesForPost(@PathVariable String postId) {
        return messageService.getMessagesForPost(postId);
    }

    @GetMapping("/user/{userId}")
    public List<Message> getMessagesForUser(@PathVariable String userId) {
        return messageService.getMessagesForUser(userId);
    }
}
