package com.trainings_notebook.backend.dao;


import com.trainings_notebook.backend.model.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

    Optional<Exercise> findByName(String name);
}
