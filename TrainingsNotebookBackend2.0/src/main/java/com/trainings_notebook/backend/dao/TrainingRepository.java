package com.trainings_notebook.backend.dao;

import com.grzegorz_malarski.trainings_notebook.model.Training;
import com.grzegorz_malarski.trainings_notebook.repositories.custom_repositories.CustomTrainingRepo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Long>, CustomTrainingRepo {
}
