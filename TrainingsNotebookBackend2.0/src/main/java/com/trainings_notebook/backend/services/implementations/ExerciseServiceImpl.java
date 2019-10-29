package com.trainings_notebook.backend.services.implementations;

import com.trainings_notebook.backend.dao.ExerciseRepository;
import com.trainings_notebook.backend.model.Exercise;
import com.trainings_notebook.backend.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private  ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }


    public ExerciseServiceImpl() {
    }

    @Override
    public Exercise findByName(String nickname) {
        return exerciseRepository.findByName(nickname).orElseThrow();
    }

    @Override
    public Set<Exercise> findAll() {
        Set<Exercise> exercises = new HashSet<>();
        exerciseRepository.findAll().forEach(exercises::add);

        return exercises;
    }

    @Override
    public Exercise findById(Long aLong) {

        return exerciseRepository.findById(aLong).orElseThrow();
    }

    @Override
    public Exercise save(Exercise object) {
        return exerciseRepository.save(object);
    }

    @Override
    public void delete(Exercise object) {

        exerciseRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {

        exerciseRepository.deleteById(aLong);
    }
}
