package com.trainings_notebook.backend.dao;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class NotebookRepositoryTest {



    @Test
    public void getAllUserNotebooks() {
    }

    @Test
    public void findAllByUserId() {
    }
}