package com.trainings_notebook.backend.dao;

import com.trainings_notebook.backend.model.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Long> {

    Optional<Training> findByName(String name);
}
