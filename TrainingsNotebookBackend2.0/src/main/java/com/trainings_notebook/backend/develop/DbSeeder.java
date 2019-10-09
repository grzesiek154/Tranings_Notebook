package com.trainings_notebook.backend.develop;

import com.trainings_notebook.backend.model.Notebook;
import com.trainings_notebook.backend.model.UserAccount;
import com.trainings_notebook.backend.services.NotebookService;
import com.trainings_notebook.backend.services.UserAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


public class DbSeeder implements CommandLineRunner {


    private final UserAccountService userAccountService;
    private final NotebookService notebookService;

    public DbSeeder(UserAccountService userAccountService, NotebookService notebookService) {
        this.userAccountService = userAccountService;
        this.notebookService = notebookService;
    }

    @Override
    public void run(String... args) throws Exception {

        UserAccount user1 = new UserAccount();
        user1.setNickname("janek123");
        user1.setName("Jan");
        user1.setSurname("Kowalski");
        user1.setEmail("jan@gmail.com");
        user1.setPassword("asdzxcqwe");
        userAccountService.save(user1);


        Notebook notebook1 = new Notebook();
        notebook1.setName("janek notebook");
        notebook1.setNote("back trainings");
        notebook1.setUser(user1);
        notebookService.save(notebook1);

        Notebook notebook2 = new Notebook();
        notebook2.setName("notebook2");
        notebook2.setNote("shoulders trainings");
        notebook2.setUser(user1);
        notebookService.save(notebook2);



    }
}
