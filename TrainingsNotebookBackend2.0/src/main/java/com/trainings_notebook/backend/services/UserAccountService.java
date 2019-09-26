package com.trainings_notebook.backend.services;


import com.trainings_notebook.backend.model.UserAccount;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserAccountService extends CrudService<UserAccount, Long> {


    UserAccount findByNickname(String nickname);
    UserAccount findByEmail(String email);
}
