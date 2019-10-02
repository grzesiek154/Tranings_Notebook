package com.trainings_notebook.backend.controllers;

import com.trainings_notebook.backend.model.Notebook;
import com.trainings_notebook.backend.model.TrainerAccount;
import com.trainings_notebook.backend.services.TrainerAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("api/trainers_accounts")
public class TrainerAccountController {

    private final TrainerAccountService trainerAccountService;

    public TrainerAccountController(TrainerAccountService trainerAccountService) {
        this.trainerAccountService = trainerAccountService;
    }

    @GetMapping(value = "/byId/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<TrainerAccount> getById(@PathVariable Long id) {

        TrainerAccount account = trainerAccountService.findById(id);

        if(account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account,HttpStatus.OK);
    }


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<TrainerAccount>> getAllAccounts() {

        Collection<TrainerAccount> accounts = trainerAccountService.findAll();
        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);

    }
    @GetMapping(value = "/byName/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<TrainerAccount> getAccountByName(@PathVariable String name) {

        TrainerAccount account = trainerAccountService.findByName(name);
        if(account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TrainerAccount> save(@RequestBody @Valid TrainerAccount account, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(account, HttpStatus.BAD_REQUEST);
        }
        trainerAccountService.save(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody @Valid TrainerAccount account, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        trainerAccountService.delete(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteById/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        TrainerAccount account = trainerAccountService.findById(id);
        if(account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        trainerAccountService.delete(account);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
