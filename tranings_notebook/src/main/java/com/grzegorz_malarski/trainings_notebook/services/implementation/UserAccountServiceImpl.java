package com.grzegorz_malarski.trainings_notebook.services.implementation;

import com.grzegorz_malarski.trainings_notebook.exceptions.NotFoundException;
import com.grzegorz_malarski.trainings_notebook.model.UserAccount;
import com.grzegorz_malarski.trainings_notebook.repositories.UserAccountRepository;
import com.grzegorz_malarski.trainings_notebook.services.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserAccountServiceImpl implements UserAccountService {


    private final UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }


    @Override
    public Set<UserAccount> findAll() {

        Set<UserAccount> users = new HashSet<>();
        userAccountRepository.findAll().forEach(users::add);

        return users;
    }

    @Override
    public UserAccount findById(Long aLong) {

        Optional<UserAccount> userAccountOptional = userAccountRepository.findById(aLong);

        if(!userAccountOptional.isPresent()) {
            throw new NotFoundException("User account with id: " + aLong + " not found");
        }

        return userAccountOptional.get();
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @Override
    public void delete(UserAccount userAccount) {
        userAccountRepository.delete(userAccount);
    }

    @Override
    public void deleteById(Long aLong) {
        userAccountRepository.deleteById(aLong);
    }
}
