package com.trainings_notebook.backend.services;


import com.trainings_notebook.backend.model.UserAccount;

public interface UserAccountService extends CrudService<UserAccount, Long> {


    UserAccount findByNickname(String nickname);

    UserAccount findByEmail(String email);


}
