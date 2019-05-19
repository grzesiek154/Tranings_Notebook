package com.grzegorz_malarski.trainings_notebook.controllers;

import com.grzegorz_malarski.trainings_notebook.model.Post;
import com.grzegorz_malarski.trainings_notebook.services.implementation.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostServiceImpl postService;

    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping("/all")
    public ResponseEntity<Set<Post>> getAllPosts() {
        Set<Post> posts = postService.findAll();
        if(posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @GetMapping("/by_title")
    public ResponseEntity<Post> getByTitle(String title) {
        Post post = postService.findByTitle(title);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
