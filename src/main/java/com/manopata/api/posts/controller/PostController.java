package com.manopata.api.posts.controller;


import com.manopata.api.posts.dto.PostRequest;
import com.manopata.api.posts.dto.PostResponse;
import com.manopata.api.posts.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@AllArgsConstructor
//@CrossOrigin
@RestController
@RequestMapping("/posts")

public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest request) {
        PostResponse response = postService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<PostResponse> editPost(@PathVariable String id, @RequestBody PostRequest request) {
        PostResponse response = postService.edit(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable String id) {
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
