package com.manopata.api.posts.services;


import com.manopata.api.posts.dto.PostRequest;
import com.manopata.api.posts.dto.PostResponse;
import com.manopata.api.posts.exceptions.PostNotFoundException;
import com.manopata.api.posts.interfaces.models.Post;
import com.manopata.api.posts.interfaces.repositories.PostRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService (PostRepository postRepository) {this.postRepository = postRepository;}

    @SneakyThrows
    public PostResponse create(PostRequest request)
    {
        String id = UUID.randomUUID().toString();
        Post post = new Post();
        post.setId(id);
        post.setPhoto(request.getPhoto());
        post.setText(request.getText());
        post.setRegisterDate(request.getRegisterDate());
        post.setName(request.getName());
        post.setAge(request.getAge());
        post.setAnimalType(request.getAnimalType());
        post.setVaccinate(request.getVaccinate());
        post.setRace(request.getRace());
        post.setPpp(request.getPpp());
        post.setCity(request.getCity());
        post.setProvince(request.getProvince());
        post.setAvailable(request.getAvailable());
        post.setLikes(request.getLikes());
        Post savedPost = postRepository.save(post);
        return new PostResponse(savedPost);
    }

    @SneakyThrows
    public PostResponse edit (String id, PostRequest request) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            throw new PostNotFoundException("Post not found with id " + id);
        }
        Post post = optionalPost.get();
        post.setPhoto(request.getPhoto());
        post.setText(request.getText());
        post.setRegisterDate(request.getRegisterDate());
        post.setName(request.getName());
        post.setAge(request.getAge());
        post.setAnimalType(request.getAnimalType());
        post.setVaccinate(request.getVaccinate());
        post.setRace(request.getRace());
        post.setPpp(request.getPpp());
        post.setCity(request.getCity());
        post.setProvince(request.getProvince());
        post.setAvailable(request.getAvailable());
        post.setLikes(request.getLikes());
        Post updatedPost = postRepository.save(post);
        return new PostResponse(updatedPost);
    }

    @SneakyThrows
    public void delete(String id)
    {
        Optional<Post> optionalUser = this.postRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new PostNotFoundException("Post not found with id " + id);
        }
        this.postRepository.delete(id);
    }

    public List<PostResponse> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostResponse::new).collect(Collectors.toList());
    }
}
