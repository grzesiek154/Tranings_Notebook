package com.trainings_notebook.backend;

import com.trainings_notebook.backend.model.Notebook;
import com.trainings_notebook.backend.model.UserAccount;
import com.trainings_notebook.backend.services.NotebookService;
import com.trainings_notebook.backend.services.UserAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendApplicationTests implements CommandLineRunner {

    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private NotebookService notebookService;

    @Test
    public void contextLoads() {

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
