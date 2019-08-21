package com.grzegorz_malarski.trainings_notebook.controllers;

import com.grzegorz_malarski.trainings_notebook.exceptions.NotFoundException;
import com.grzegorz_malarski.trainings_notebook.model.Comment;
import com.grzegorz_malarski.trainings_notebook.model.Post;
import com.grzegorz_malarski.trainings_notebook.services.implementation.CommentServiceImpl;
import com.grzegorz_malarski.trainings_notebook.services.implementation.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api/comments")
public class CommentController {


    private final CommentServiceImpl commentService;
    private final PostServiceImpl postService;

    public CommentController(CommentServiceImpl commentService, PostServiceImpl postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @GetMapping("/all")
    public ResponseEntity<Set<Comment>> getAllComments() {
        Set<Comment> comments = commentService.findAll();
        if(comments.isEmpty()) {
            throw new NotFoundException("Comments not found");
        } else {
            return new ResponseEntity<>(comments, HttpStatus.OK);
        }
    }
    @GetMapping("/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable Long postId) {

        Post post = postService.findById(postId);
        if(post == null) {
            throw new NotFoundException("Post with id:" + postId + " not found.");
        }
        List<Comment> postComments = post.getComments();

        return new ResponseEntity<>(postComments, HttpStatus.OK);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long commentId) {

        Comment comment = commentService.findById(commentId);
        if(comment == null) {
            throw new NotFoundException("Comment with id:" + commentId + " not found.");
        }
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comment> save(@RequestBody Comment comment, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }
        Comment savedComment = commentService.save(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{commentId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> deleteById(@PathVariable Long commentId) {
        Comment comment = commentService.findById(commentId);

        if(comment != null) {
            commentService.deleteById(commentId);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
