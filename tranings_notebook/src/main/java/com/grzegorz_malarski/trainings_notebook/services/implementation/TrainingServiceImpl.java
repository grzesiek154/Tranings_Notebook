package com.grzegorz_malarski.trainings_notebook.services.implementation;

import com.grzegorz_malarski.trainings_notebook.exceptions.NotFoundException;
import com.grzegorz_malarski.trainings_notebook.model.Training;
import com.grzegorz_malarski.trainings_notebook.repositories.TrainingRepository;
import com.grzegorz_malarski.trainings_notebook.services.TrainingService;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TrainingServiceImpl implements TrainingService {

   private final TrainingRepository trainingRepository;

    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public Set<Training> findAll() {
        Set<Training> trainings = new HashSet<>();
        trainingRepository.findAll().forEach(trainings::add);

        return trainings;
    }

    @Override
    public Training findById(Long aLong) {
        Optional<Training> userAccountOptional = trainingRepository.findById(aLong);

        if(!userAccountOptional.isPresent()) {
            throw new NotFoundException("User account with id: " + aLong + " not found");
        }

        return userAccountOptional.get();
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
