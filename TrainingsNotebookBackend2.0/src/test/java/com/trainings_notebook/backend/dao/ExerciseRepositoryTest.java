package com.trainings_notebook.backend.dao;

import com.trainings_notebook.backend.model.Exercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ExerciseRepositoryTest {


    String EXERCISE_NAME = "pullups";
    @Autowired
    private ExerciseRepository exerciseRepository;

    @BeforeEach
    void setUp() {
        Exercise exercise = new Exercise();
        exercise.setId(1L);
        exercise.setName(EXERCISE_NAME);
        exercise.setDescription("this is pullup workouts");
        exerciseRepository.save(exercise);
    }

    @Test
    void findByName() {

        Exercise exercise = exerciseRepository.findByName(EXERCISE_NAME).orElseThrow();
        assertNotNull(exercise);
        assertEquals("pullups", exercise.getName());

    }
}