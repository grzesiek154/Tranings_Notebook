package com.grzegorz_malarski.trainings_notebook.services.implementation;

import com.grzegorz_malarski.trainings_notebook.exceptions.NotFoundException;
import com.grzegorz_malarski.trainings_notebook.model.Exercise;
import com.grzegorz_malarski.trainings_notebook.repositories.ExerciseRepository;
import com.grzegorz_malarski.trainings_notebook.services.ExerciseService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Set<Exercise> findAll() {

        Set<Exercise> exercises = new HashSet<>();
        exerciseRepository.findAll().forEach(exercises::add);

        return exercises;
    }

    @Override
    public Exercise findById(Long aLong) {
        Optional<Exercise> userAccountOptional = exerciseRepository.findById(aLong);

        if(!userAccountOptional.isPresent()) {
            throw new NotFoundException("User account with id: " + aLong + " not found");
        }

        return userAccountOptional.get();
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
