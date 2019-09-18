package com.grzegorz_malarski.trainings_notebook.develop;

import com.grzegorz_malarski.trainings_notebook.model.Notebook;
import com.grzegorz_malarski.trainings_notebook.model.UserAccount;
import com.grzegorz_malarski.trainings_notebook.repositories.TrainerAccountRepository;
import com.grzegorz_malarski.trainings_notebook.repositories.UserAccountRepository;
import com.grzegorz_malarski.trainings_notebook.services.implementation.ApplicationService;
import com.grzegorz_malarski.trainings_notebook.services.implementation.UserAccountServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DBSeeder implements CommandLineRunner {


    private final UserAccountRepository userAccountRepository;
    private final TrainerAccountRepository trainerAccountRepository;
    private final UserAccountServiceImpl userAccountService;
    private final ApplicationService applicationService;

    public DBSeeder(UserAccountRepository userAccountRepository, TrainerAccountRepository trainerAccountRepository, UserAccountServiceImpl userAccountService, ApplicationService applicationService) {
        this.userAccountRepository = userAccountRepository;
        this.trainerAccountRepository = trainerAccountRepository;
        this.userAccountService = userAccountService;
        this.applicationService = applicationService;
    }

    @Override
    public void run(String... args) throws Exception {



            UserAccount user1 = new UserAccount();
            user1.setNickname("janek123");
            user1.setName("Jan");
            user1.setSurname("Kowalski");
            user1.setEmail("jan@gmail.com");
            user1.setPassword("asdzxcqwe");
            applicationService.addNewUserAccount(user1);

        user1.setNickname("Janusz");
        applicationService.addNewUserAccount(user1);

//            UserAccount user3 = new UserAccount();
//            user3.setNickname("janek123");
//            user3.setName("Jan");
//            user3.setSurname("Kowalski");
//            user3.setEmail("jan@gmail.com");
//            user3.setPassword("asdzxcqwe");
//            userAccountService.addNewUserAccount(user3);

            UserAccount user2 = new UserAccount();
            user2.setNickname("adam987");
            user2.setName("Adam");
            user2.setSurname("Nowak");
            user2.setEmail("adam@gmail.com");
            user2.setPassword("asdzxcqwe");
            userAccountRepository.save(user2);


            Notebook user1Notebook = new Notebook();
            user1Notebook.setName("Chest trainings");


    }


}
