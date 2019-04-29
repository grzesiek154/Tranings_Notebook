package com.grzegorz_malarski.trainings_notebook.repositories.custom_repositories;

import com.grzegorz_malarski.trainings_notebook.model.Training;

import java.util.Optional;

public interface CustomTrainingRepo {

    Optional<Training> findByName(String namme);
}
