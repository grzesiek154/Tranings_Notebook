package com.grzegorz_malarski.trainings_notebook.controllers;

import com.grzegorz_malarski.trainings_notebook.model.Post;
import com.grzegorz_malarski.trainings_notebook.services.implementation.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
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
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }
    }
    @GetMapping("/by_title")
    public ResponseEntity<Post> getByTitle(String title) {
        Post post = postService.findByTitle(title);

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Post> getPostNyId(@PathVariable Long id) {
        Post post = postService.findById(id);

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody Post post, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }
        Post savedPost = postService.save(post);
        return new ResponseEntity<>(savedPost, HttpStatus.OK);
    }

    //public ResponseEntity<Void> delete()

}
