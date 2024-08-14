package com.manopata.api.posts.services;

import com.manopata.api.posts.dto.PostRequest;
import com.manopata.api.posts.dto.PostResponse;
import com.manopata.api.posts.exceptions.PostNotFoundException;
import com.manopata.api.posts.interfaces.models.Post;
import com.manopata.api.posts.interfaces.repositories.JpaPostRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final JpaPostRepository postRepository;

    @Autowired
    public PostService(JpaPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @SneakyThrows
    public PostResponse create(PostRequest request) {
        String id = UUID.randomUUID().toString();
        Post post = new Post();
        post.setId(id);
        post.setPhoto(request.getPhoto());
        post.setText(request.getText());
        post.setRegisterDate(LocalDate.now());
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
        return new PostResponse(postRepository.save(post));
    }

    public PostResponse edit(String id, PostRequest request) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            throw new PostNotFoundException("Post not found with id " + id);
        }
        Post post = optionalPost.get();
        post.setPhoto(request.getPhoto());
        post.setText(request.getText());
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
        return new PostResponse(postRepository.save(post));
    }

    public void delete(String id) {
        postRepository.deleteById(id);
    }

    public PostResponse findById(String id) {
        return postRepository.findById(id)
                .map(PostResponse::new)
                .orElseThrow(() -> new PostNotFoundException("Post not found with id " + id));
    }

    public List<PostResponse> getAllPosts() {
        return postRepository.findAll().stream().map(PostResponse::new).collect(Collectors.toList());
    }

    public List<PostResponse> getLatestPosts() {
        return postRepository.findTop4ByOrderByRegisterDateDesc().stream().map(PostResponse::new).collect(Collectors.toList());
    }
}
