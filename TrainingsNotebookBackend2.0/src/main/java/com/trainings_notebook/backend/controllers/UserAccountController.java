package com.trainings_notebook.backend.controllers;


import com.trainings_notebook.backend.model.UserAccount;
import com.trainings_notebook.backend.services.UserAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping
public class UserAccountController {

    private final UserAccountService userAccountService;


    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping(value = "/byId/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserAccount> getById(@PathVariable Long id) {

        UserAccount account = userAccountService.findById(id);

        if(account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account,HttpStatus.OK);
    }


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<UserAccount>> getAllAccounts() {

        Collection<UserAccount> accounts = userAccountService.findAll();
        if(accounts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping(value = "/byName/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserAccount> getAccountByNickname(@PathVariable String name) {

        UserAccount account = userAccountService.findByNickname(name);
        if(account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserAccount> save(@RequestBody @Valid UserAccount account, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(account, HttpStatus.BAD_REQUEST);
        }
        userAccountService.save(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody @Valid UserAccount account, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userAccountService.delete(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteById/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        UserAccount account = userAccountService.findById(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userAccountService.delete(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
