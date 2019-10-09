package com.trainings_notebook.backend.develop;

import com.trainings_notebook.backend.dao.NotebookRepository;
import com.trainings_notebook.backend.dao.UserAccountRepository;
import com.trainings_notebook.backend.model.Notebook;
import com.trainings_notebook.backend.model.UserAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("default")
public class BootstrapMySqlData implements ApplicationListener<ContextRefreshedEvent> {

    private final UserAccountRepository userAccountRepository;
    private final NotebookRepository notebookRepository;
    private UserAccount user1;

    public BootstrapMySqlData(UserAccountRepository userAccountRepository, NotebookRepository notebookRepository) {
        this.userAccountRepository = userAccountRepository;
        this.notebookRepository = notebookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if(userAccountRepository.count() == 0L) {
            log.debug("loading users accounts");
            loadUsers();
        }

        if(notebookRepository.count() == 0L) {
            log.debug("loading notebooks");
            loadNotebooks();
        }
    }



    private void loadUsers(){
        user1 = new UserAccount();
        user1.setNickname("janek123");
        user1.setName("Jan");
        user1.setSurname("Kowalski");
        user1.setEmail("jan@gmail.com");
        user1.setPassword("asdzxcqwe");
        userAccountRepository.save(user1);
    }

    private void loadNotebooks() {
        Notebook notebook1 = new Notebook();
        notebook1.setName("janek notebook");
        notebook1.setNote("back trainings");
        notebook1.setUser(user1);
        notebookRepository.save(notebook1);

        Notebook notebook2 = new Notebook();
        notebook2.setName("notebook2");
        notebook2.setNote("shoulders trainings");
        notebook2.setUser(user1);
        notebookRepository.save(notebook2);

        Notebook notebook3 = new Notebook();
        notebook3.setName("notebook3");
        notebook3.setNote("legs trainings");
        notebook3.setUser(user1);
        notebookRepository.save(notebook3);

        Notebook notebook4 = new Notebook();
        notebook4.setName("notebook3");
        notebook4.setNote("legs trainings");
        notebook4.setUser(user1);
        notebookRepository.save(notebook4);
    }
}
