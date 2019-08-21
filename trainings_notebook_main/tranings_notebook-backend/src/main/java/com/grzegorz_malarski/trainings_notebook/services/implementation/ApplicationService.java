package com.grzegorz_malarski.trainings_notebook.services.implementation;

import com.grzegorz_malarski.trainings_notebook.exceptions.EmailNotUniqueException;
import com.grzegorz_malarski.trainings_notebook.exceptions.NicknameNotUniqueException;
import com.grzegorz_malarski.trainings_notebook.model.UserAccount;
import com.grzegorz_malarski.trainings_notebook.repositories.UserAccountRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * class which has methods more general for whole application
 */
@Service
public class ApplicationService {

    private final UserAccountRepository userAccountRepository;


    public ApplicationService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    private boolean checkWhetherUserCanBeCreated(UserAccount userAccount) throws EmailNotUniqueException, NicknameNotUniqueException {

        Optional<UserAccount> userByNickname = userAccountRepository.findByNickname(userAccount.getNickname());
        Optional<UserAccount> userByEmail = userAccountRepository.findByNickname(userAccount.getEmail());

        if(userByNickname.isEmpty()) {
            if(userByEmail.isEmpty()) {
                return true;
            } else {
                throw new EmailNotUniqueException("User with email: " + userAccount.getEmail() + " is already registrated");
            }
        } else {
            throw new NicknameNotUniqueException("User witn nickname: " + userAccount.getNickname()+ " is already registrated");
        }
    }

    public boolean checkWhetherEntityCanBeAdded(CrudRepository repository, Long id) {

        Optional<Object> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return true;

        }
        return false;
    }

    public void addNewUserAccount(UserAccount userAccount) throws EmailNotUniqueException, NicknameNotUniqueException{

        if (checkWhetherUserCanBeCreated(userAccount)) {
            userAccountRepository.save(userAccount);
        }
    }
}
