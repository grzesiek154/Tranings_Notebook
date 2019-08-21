package com.grzegorz_malarski.trainings_notebook.controllers;

import com.grzegorz_malarski.trainings_notebook.exceptions.NotFoundException;
import com.grzegorz_malarski.trainings_notebook.model.UserAccount;
import com.grzegorz_malarski.trainings_notebook.services.implementation.UserAccountServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.Set;

@RestController
@RequestMapping("/apu/users")
public class UserAccountController {

    private final UserAccountServiceImpl userAccountService;

    public UserAccountController(UserAccountServiceImpl userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/all")
    public ResponseEntity<Set<UserAccount>> getAllAccounts() {
        Set<UserAccount> accounts = userAccountService.findAll();
        if(accounts.isEmpty()) {
            throw new NotFoundException("Notebooks not found");
        } else {
            return new ResponseEntity<>(accounts, HttpStatus.OK);
        }
    }


    @GetMapping("/{accountId}")
    public ResponseEntity<UserAccount> getNotebookById(@PathVariable Long accountId) {

        UserAccount account = userAccountService.findById(accountId);
        if(account == null) {
            throw new NotFoundException("Account with id:" + accountId + " not found.");
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserAccount> save(@RequestBody UserAccount account, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }
        UserAccount savedAccount = userAccountService.save(account);
        return new ResponseEntity<>(savedAccount, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{accountId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> deleteById(@PathVariable Long accountId) {
        UserAccount account = userAccountService.findById(accountId);

        if(account != null) {
            userAccountService.deleteById(accountId);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(value = "/{nickname}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserAccount> getByNickName(@PathVariable String nickname) {
        UserAccount account = userAccountService.findByNickname(nickname);
        if(account == null) {
            throw new NotFoundException("Account wit nickname " + nickname + " not found");
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping(value = "/{email}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserAccount> getByNickEmail(@PathVariable String email) {
        UserAccount account = userAccountService.findByEmail(email);
        if(account == null) {
            throw new NotFoundException("Account wit nickname " + email + " not found");
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
