package com.trainings_notebook.backend.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class TrainerAccountRepositoryTest {



    @Autowired
    private TrainerAccountRepository trainerAccountRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByName() {
    }
}