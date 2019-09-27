package com.trainings_notebook.backend.controllers;

import com.trainings_notebook.backend.model.Comment;
import com.trainings_notebook.backend.model.Notebook;
import com.trainings_notebook.backend.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("api/comments")
public class CommentController {

  private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @GetMapping(value = "/byId/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Comment> getById(@PathVariable Long id) {

        Comment comment = commentService.findById(id);

        if(comment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comment,HttpStatus.OK);
    }


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Comment>> getAllNotebooks() {

        Collection<Comment> comments = commentService.findAll();
        if(comments.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<Comment> save(@RequestBody @Valid Comment comment, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(comment, HttpStatus.BAD_REQUEST);
        }
        commentService.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Comment> delete(@RequestBody @Valid Comment comment, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(comment, HttpStatus.BAD_REQUEST);
        }
        commentService.delete(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteById/{id}")
    public ResponseEntity<Comment> delete(@PathVariable Long id) {

        Comment comment = commentService.findById(id);
        if(comment == null) {
            return new ResponseEntity<>(comment, HttpStatus.NOT_FOUND);
        }
        commentService.delete(comment);
        return new ResponseEntity<>(comment, HttpStatus.NO_CONTENT);
    }
}
