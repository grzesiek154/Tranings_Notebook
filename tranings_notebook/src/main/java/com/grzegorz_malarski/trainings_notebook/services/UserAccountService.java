package com.grzegorz_malarski.trainings_notebook.services;

import com.grzegorz_malarski.trainings_notebook.model.UserAccount;

public interface UserAccountService extends CrudService<UserAccount, Long> {


    UserAccount findByNickname(String nickname);

    UserAccount findByEmail(String email);


}
