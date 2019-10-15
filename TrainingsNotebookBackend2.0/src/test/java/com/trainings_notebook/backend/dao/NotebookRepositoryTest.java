package com.trainings_notebook.backend.dao;

import com.trainings_notebook.backend.BackendApplication;
import com.trainings_notebook.backend.model.Notebook;
import com.trainings_notebook.backend.model.UserAccount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.weaver.ast.Not;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApplication.class)
public class NotebookRepositoryTest {

//    Logger logger = LogManager.getLogger(getClass());
//

    String NOTEBOOK_NAME = "janek notebook";
    String NOTEBOOK_NAME2 = "notebook2";
    String NOTEBOOK_NAME3 = "notebook3";

    @Autowired
    private NotebookRepository notebookRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;



    @Test
    public void getAllUserNotebooks() {
        List<String> notebooks = new ArrayList<>();
        notebookRepository.getAllUserNotebooks(1L).forEach(notebooks::add);

        assertNotNull(notebooks);
        assertEquals(NOTEBOOK_NAME, notebooks.get(0));
        assertEquals(NOTEBOOK_NAME2, notebooks.get(1));
        assertEquals(NOTEBOOK_NAME3, notebooks.get(2));
    }

    @Test
    public void findByName() {

        Optional<Notebook> notebook = notebookRepository.findByName(NOTEBOOK_NAME);
        assertNotNull(notebook);
        assertEquals(NOTEBOOK_NAME, notebook.get().getName());
    }
}