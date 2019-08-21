package com.grzegorz_malarski.trainings_notebook.controllers;

import com.grzegorz_malarski.trainings_notebook.exceptions.NotFoundException;
import com.grzegorz_malarski.trainings_notebook.model.Comment;
import com.grzegorz_malarski.trainings_notebook.model.Post;
import com.grzegorz_malarski.trainings_notebook.model.TrainerAccount;
import com.grzegorz_malarski.trainings_notebook.services.implementation.TrainerAccountServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/trainers_accounts")
public class TrainerAccountController {

    private final TrainerAccountServiceImpl trainerAccountService;

    public TrainerAccountController(TrainerAccountServiceImpl trainerAccountService) {
        this.trainerAccountService = trainerAccountService;
    }

    @GetMapping("/all")
    public ResponseEntity<Set<TrainerAccount>> getAllTrainersAccounts() {
        Set<TrainerAccount> trainersAccounts = trainerAccountService.findAll();
        if(trainersAccounts.isEmpty()) {
            throw new NotFoundException("Comments not found");
        } else {
            return new ResponseEntity<>(trainersAccounts, HttpStatus.OK);
        }
    }
    @GetMapping("/{accountId}")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable Long accountId) {

        TrainerAccount account = trainerAccountService.findById(accountId);
        if(account == null) {
            throw new NotFoundException("Post with id:" + accountId + " not found.");
        }
        List<Comment> postComments = account.getComments();

        return new ResponseEntity<>(postComments, HttpStatus.OK);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<TrainerAccount> getCommentById(@PathVariable Long accountId) {

        TrainerAccount account = trainerAccountService.findById(accountId);
        if(account == null) {
            throw new NotFoundException("Comment with id:" + accountId + " not found.");
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TrainerAccount> save(@RequestBody TrainerAccount account, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }
        TrainerAccount savedAccount = trainerAccountService.save(account);
        return new ResponseEntity<>(savedAccount, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{accountId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> deleteById(@PathVariable Long accountId) {
        TrainerAccount account = trainerAccountService.findById(accountId);

        if(account != null) {
            trainerAccountService.deleteById(accountId);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
