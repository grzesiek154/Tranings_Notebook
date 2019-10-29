package com.trainings_notebook.backend.dao;

import com.trainings_notebook.backend.model.TrainerAccount;
import com.trainings_notebook.backend.model.Training;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class TrainingRepositoryTest {

    private String TRAINING_NAME = "Chest training";
    @Autowired
    private TrainingRepository trainingRepository;
    @Autowired
    private TrainerAccountRepository trainerAccountRepository;

    @BeforeEach
    void setUp() {
        TrainerAccount trainer = new TrainerAccount();
        trainer.setName("Jan");
        trainer.setSurname("Kowalski");
        trainer.setPassword("tajnehaslo");
        trainer.setEmail("jankowalski@gmail.com");

        Training training = new Training();
        training.setAuthor(trainer);
        training.setName(TRAINING_NAME);
        trainerAccountRepository.save(trainer);
        trainingRepository.save(training);
    }

    @Test
    void findByName() {
       Training training = trainingRepository.findByName(TRAINING_NAME).orElseThrow();
       assertNotNull(training);
       assertEquals(TRAINING_NAME, training.getName());
    }
}