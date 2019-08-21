package com.grzegorz_malarski.trainings_notebook.services.implementation;

import com.grzegorz_malarski.trainings_notebook.exceptions.NotFoundException;
import com.grzegorz_malarski.trainings_notebook.model.Notebook;
import com.grzegorz_malarski.trainings_notebook.model.Training;
import com.grzegorz_malarski.trainings_notebook.model.UserAccount;
import com.grzegorz_malarski.trainings_notebook.repositories.NotebookRepository;
import com.grzegorz_malarski.trainings_notebook.repositories.UserAccountRepository;
import com.grzegorz_malarski.trainings_notebook.services.NotebookService;
import com.grzegorz_malarski.trainings_notebook.repositories.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class NotebookServiceImpl implements NotebookService {

    private final NotebookRepository notebookRepository;
    private final TrainingRepository trainingRepository;
    private final UserAccountRepository userAccountRepository;


    public NotebookServiceImpl(NotebookRepository notebookRepository, TrainingRepository trainingRepository, UserAccountRepository userAccountRepository) {
        this.notebookRepository = notebookRepository;
        this.trainingRepository = trainingRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public Set<Notebook> findAll() {
        Set<Notebook> notebooks = new HashSet<>();
        notebookRepository.findAll().forEach(notebooks::add);

        return notebooks;
    }

    @Override
    public Notebook findById(Long aLong) {

        Optional<Notebook> userAccountOptional = notebookRepository.findById(aLong);

        if(!userAccountOptional.isPresent()) {
            throw new NotFoundException("User account with id: " + aLong + " not found");
        }

        return userAccountOptional.get();
    }

    @Override
    public Notebook findByName(String name) {
        return null;
    }

    @Override
    public Notebook save(Notebook object) {

//       Optional<UserAccount> userAccountOptional = userAccountRepository.findById()

        return notebookRepository.save(object);
    }

    @Override
    public void delete(Notebook object) {
        notebookRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        notebookRepository.deleteById(aLong);
    }

    public void addTraining(Notebook notebook, Training training) {

        if(checkWhetherEntityCanBeAdded(training)) {
            notebook.getTrainings().add(training);
            trainingRepository.save(training);
        } else {
            throw new RuntimeException("Training with id ");
        }

    }



    private boolean checkWhetherEntityCanBeAdded(Training training) {

        Optional<Training> trainingOptional = trainingRepository.findByName(training.getName());
        if(!trainingOptional.isPresent()) {
            return true;
        }
        return  false;
    }
}
