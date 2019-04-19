package com.grzegorz_malarski.trainings_notebook.repositories;

import com.grzegorz_malarski.trainings_notebook.model.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Long> {
}
