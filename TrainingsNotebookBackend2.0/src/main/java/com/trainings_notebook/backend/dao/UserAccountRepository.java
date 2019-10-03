package com.trainings_notebook.backend.dao;


import com.trainings_notebook.backend.model.Training;
import com.trainings_notebook.backend.model.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {


    Optional<UserAccount> findByNickname(String nickname);
    Optional<UserAccount> findByEmail(String email);


}
