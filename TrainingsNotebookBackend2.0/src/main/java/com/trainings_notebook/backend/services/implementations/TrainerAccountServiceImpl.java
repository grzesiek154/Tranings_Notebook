package com.trainings_notebook.backend.services.implementations;

import com.trainings_notebook.backend.dao.TrainerAccountRepository;
import com.trainings_notebook.backend.model.TrainerAccount;
import com.trainings_notebook.backend.services.TrainerAccountService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TrainerAccountServiceImpl implements TrainerAccountService {

    private final TrainerAccountRepository trainerAccountRepository;

    public TrainerAccountServiceImpl(TrainerAccountRepository trainerAccountRepository) {
        this.trainerAccountRepository = trainerAccountRepository;
    }

    @Override
    public Set<TrainerAccount> findAll() {
        Set<TrainerAccount> accounts = new HashSet<>();
        trainerAccountRepository.findAll().forEach(accounts::add);

        return accounts;
    }

    @Override
    public TrainerAccount findById(Long aLong) {
        return trainerAccountRepository.findById(aLong).orElseThrow();
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
