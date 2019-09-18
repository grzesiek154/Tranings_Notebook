package com.grzegorz_malarski.trainings_notebook.repositories.custom_repositories;

import com.grzegorz_malarski.trainings_notebook.model.UserAccount;

import java.util.Optional;

public interface CustomUserAccountRepo {

    Optional<UserAccount> findByNickname(String nickname);

    Optional<UserAccount> findByEmail(String email);
}
