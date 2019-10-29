package com.trainings_notebook.backend.services.implementations;

import com.trainings_notebook.backend.dao.ExerciseRepository;
import com.trainings_notebook.backend.model.Exercise;
import com.trainings_notebook.backend.services.ExerciseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.BeanProperty;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class ExerciseServiceImplTest {


    @TestConfiguration
    static class ExerciseServiceImplTestContextConfiguration {

        @Bean
        public ExerciseService exerciseService() {
            return new ExerciseServiceImpl();
        }
    }

    @Autowired
    private ExerciseService exerciseService;
    @MockBean
    private ExerciseRepository exerciseRepository;

    @BeforeEach
    void setUp() {
        Exercise exercise1 = new Exercise();
        exercise1.setName("pushups");

        Exercise exercise2 = new Exercise();
        exercise2.setName("situps");

        List<Exercise> exercises = Arrays.asList(exercise1,exercise2);

        Optional<Exercise> exerciseOptional = Optional.of(exercise1);

        Mockito.when(exerciseRepository.findByName(exercise1.getName())).thenReturn(exerciseOptional);
        Mockito.when(exerciseRepository.findByName("wrong name").orElseThrow()).thenReturn(null);
        Mockito.when(exerciseRepository.findById(exercise1.getId()).orElseThrow()).thenReturn(exercise1);
        Mockito.when(exerciseRepository.findAll()).thenReturn(exercises);
    }

    @Test
    void findByName() {

        String name = "pushups";
        Exercise exercise = exerciseService.findByName(name);

        assertEquals(name, exercise.getName());
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}