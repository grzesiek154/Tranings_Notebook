package com.trainings_notebook.backend.dao;

import com.trainings_notebook.backend.model.Notebook;
import com.trainings_notebook.backend.model.UserAccount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NotebookRepositoryTest {

//    Logger logger = LogManager.getLogger(getClass());
//
    @Autowired
    private NotebookRepository notebookRepository;
//    @Autowired
//    private UserAccountRepository userAccountRepository;
//
//    @Before
//    public void setUp() throws Exception {
//        UserAccount user1 = new UserAccount();
//        user1.setNickname("janek123");
//        user1.setName("Jan");
//        user1.setSurname("Kowalski");
//        user1.setEmail("jan@gmail.com");
//        user1.setPassword("asdzxcqwe");
//        userAccountRepository.save(user1);
//
//        Notebook notebook2 = new Notebook();
//        notebook2.setName("notebook2");
//        notebook2.setNote("shoulders trainings");
//        notebook2.setUser(user1);
//        notebookRepository.save(notebook2);
//    }

    @Test
    public void getAllUserNotebooks() {
    }

    @Test
    public void findAllByUserId() {
    }

    @Test
    public void findByName() {

        Optional<Notebook> notebook = notebookRepository.findByName("notebook2");
        assertNotNull(notebook);
        assertEquals("notebook2", notebook.get().getName());

    }
}