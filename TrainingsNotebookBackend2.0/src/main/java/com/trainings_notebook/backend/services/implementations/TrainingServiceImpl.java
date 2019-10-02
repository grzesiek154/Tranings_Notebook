package com.trainings_notebook.backend.services.implementations;

import com.trainings_notebook.backend.dao.TrainingRepository;
import com.trainings_notebook.backend.model.Training;
import com.trainings_notebook.backend.services.TrainingService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;

    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public Training findByName(String name) {

        return trainingRepository.findByName(name).orElseThrow();
    }

    @Override
    public Set<Training> findAll() {
        Set<Training> trainings = new HashSet<>();
        trainingRepository.findAll().forEach(trainings::add);

        return trainings;
    }

    @Override
    public Training findById(Long aLong) {
        return trainingRepository.findById(aLong).orElseThrow();
    }

    @Override
    public Training save(Training object) {
        return trainingRepository.save(object);
    }

    @Override
    public void delete(Training object) {
        trainingRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        trainingRepository.deleteById(aLong);
    }
}