package com.grzegorz_malarski.trainings_notebook.services.implementation;

import com.grzegorz_malarski.trainings_notebook.model.UserAccount;
import com.grzegorz_malarski.trainings_notebook.repositories.UserAccountRepository;
import com.grzegorz_malarski.trainings_notebook.services.UserAccountService;

import java.util.Set;

public class UserAccountServiceImpl implements UserAccountService {


    private final UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }


    @Override
    public Set<UserAccount> findAll() {
        return null;
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
