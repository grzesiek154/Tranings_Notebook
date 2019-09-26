package com.trainings_notebook.backend.services.implementations;

import com.trainings_notebook.backend.dao.UserAccountRepository;
import com.trainings_notebook.backend.model.UserAccount;
import com.trainings_notebook.backend.services.UserAccountService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserAccountServiceImpl implements UserAccountService {

   private final UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }


    @Override
    public UserAccount findByNickname(String nickname) {
        return userAccountRepository.findByNickname(nickname).orElseThrow();
    }

    @Override
    public UserAccount findByEmail(String email) {
        return userAccountRepository.findByEmail(email).orElseThrow();
    }


    @Override
    public Set<UserAccount> findAll() {
        Set<UserAccount> accounts = new HashSet<>();
        userAccountRepository.findAll().forEach(accounts::add);

        return accounts;
    }

    @Override
    public UserAccount findById(Long aLong) {
        return null;
    }

    @Override
    public UserAccount save(UserAccount object) {
        return null;
    }

    @Override
    public void delete(UserAccount object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

}
