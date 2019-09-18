package com.trainings_notebook.backend.dao;

import com.grzegorz_malarski.trainings_notebook.model.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
}
