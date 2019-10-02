package com.trainings_notebook.backend.controllers;


import com.trainings_notebook.backend.model.Post;
import com.trainings_notebook.backend.services.PostService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/byId/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Post> getById(@PathVariable Long id) {

        Post post = postService.findById(id);

        if(post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post,HttpStatus.OK);
    }


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Post>> getAllPosts() {

        Collection<Post> notebooks = postService.findAll();
        if(notebooks.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(notebooks, HttpStatus.OK);
    }

    @GetMapping(value = "/byName/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Post> getPostByTitle(@PathVariable String title) {

        Post post = postService.findByTitle(title);
        if(post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody @Valid Post post, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        postService.save(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody @Valid Post post, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        postService.delete(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteById/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        Post post = postService.findById(id);
        if(post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postService.delete(post);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
