package com.grzegorz_malarski.trainings_notebook.model;

import com.grzegorz_malarski.trainings_notebook.repositories.TrainerAccountRepository;
import com.grzegorz_malarski.trainings_notebook.repositories.UserAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;


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



            UserAccount user1 = new UserAccount();
            user1.setName("Jan");
            user1.setSurname("Kowalski");
            user1.setEmail("jan@gmail.com");
            user1.setPassword("asdzxcqwe");
            userAccountRepository.save(user1);

            UserAccount user2 = new UserAccount();
            user2.setName("Adam");
            user2.setSurname("Nowak");
            user2.setEmail("adam@gmail.com");
            user2.setPassword("asdzxcqwe");
            userAccountRepository.save(user2);


            Notebook user1Notebook = new Notebook();
            user1Notebook.setName("Chest Trainings");






    }


}
