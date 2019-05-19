package com.grzegorz_malarski.trainings_notebook.controllers;

import com.grzegorz_malarski.trainings_notebook.model.Comment;
import com.grzegorz_malarski.trainings_notebook.services.implementation.CommentServiceImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;


@RestController
@RequestMapping("/api/app_users")
public class CommentController {


    private final CommentServiceImpl commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }



    @PostMapping
    public Comment save(@RequestBody Comment comment, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            throw  new ValidationException();
        }
        return commentService.save(comment);
    }



}
