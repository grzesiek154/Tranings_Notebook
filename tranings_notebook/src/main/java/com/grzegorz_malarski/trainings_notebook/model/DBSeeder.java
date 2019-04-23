package com.grzegorz_malarski.trainings_notebook.model;

import com.grzegorz_malarski.trainings_notebook.repositories.TrainerAccountRepository;
import com.grzegorz_malarski.trainings_notebook.repositories.UserAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBSeeder implements CommandLineRunner {


    private final UserAccountRepository userAccountRepository;
    private final TrainerAccountRepository trainerAccountRepository;

    public DBSeeder(UserAccountRepository userAccountRepository, TrainerAccountRepository trainerAccountRepository) {
        this.userAccountRepository = userAccountRepository;
        this.trainerAccountRepository = trainerAccountRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        UserAccount userAccount = new UserAccount();
        userAccount.setName("Jan");
        userAccount.setSurname("Kowalski");
        userAccount.setEmail("jan@gmail.com");
        userAccount.setPassword("asdzxcqwe");



        userAccountRepository.save(userAccount);

    }
}
