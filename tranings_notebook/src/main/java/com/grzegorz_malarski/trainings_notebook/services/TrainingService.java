package com.grzegorz_malarski.trainings_notebook.services;

import com.grzegorz_malarski.trainings_notebook.model.Training;

public interface TrainingService extends CrudService<Training, Long> {

    Training findByName(String name);
}
