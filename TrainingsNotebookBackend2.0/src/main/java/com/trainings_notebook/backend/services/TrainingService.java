package com.trainings_notebook.backend.services;


import com.trainings_notebook.backend.model.Training;

public interface TrainingService extends CrudService<Training, Long> {

    Training findByName(String name);
}
