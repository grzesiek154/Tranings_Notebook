package com.grzegorz_malarski.trainings_notebook.services.implementation;

import com.grzegorz_malarski.trainings_notebook.exceptions.NotFoundException;
import com.grzegorz_malarski.trainings_notebook.model.TrainerAccount;
import com.grzegorz_malarski.trainings_notebook.repositories.TrainerAccountRepository;
import com.grzegorz_malarski.trainings_notebook.services.TrainerAccountService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TrainerAccountServiceImpl implements TrainerAccountService {



    private final TrainerAccountRepository trainerAccountRepository;

    public TrainerAccountServiceImpl(TrainerAccountRepository trainerAccountRepository) {
        this.trainerAccountRepository = trainerAccountRepository;
    }


    @Override
    public Set<TrainerAccount> findAll() {
        Set<TrainerAccount> trainers = new HashSet<>();
        trainerAccountRepository.findAll().forEach(trainers::add);

        return trainers;
    }

    @Override
    public TrainerAccount findById(Long aLong) {
        Optional<TrainerAccount> userAccountOptional = trainerAccountRepository.findById(aLong);

        if(!userAccountOptional.isPresent()) {
            throw new NotFoundException("User account with id: " + aLong + " not found");
        }

        return userAccountOptional.get();
    }

    @Override
    public TrainerAccount save(TrainerAccount object) {
        return trainerAccountRepository.save(object);
    }

    @Override
    public void delete(TrainerAccount object) {
        trainerAccountRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        trainerAccountRepository.deleteById(aLong);
    }
}
