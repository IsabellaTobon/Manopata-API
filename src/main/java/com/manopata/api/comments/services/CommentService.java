package com.manopata.api.comments.services;

import com.manopata.api.comments.interfaces.repositories.CommentRepository;
import com.manopata.api.roles.dto.RolResponse;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service

public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) { this.commentRepository = commentRepository; }

    @SneakyThrows

    public RolResponse
}
