package com.manopata.api.posts.services;

import com.manopata.api.posts.dto.PostRequest;
import com.manopata.api.posts.dto.PostResponse;
import com.manopata.api.posts.interfaces.repositories.PostRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) { this.postRepository= postRepository; }

    @SneakyThrows
    public PostResponse create (PostRequest request)
    {

    }

}
