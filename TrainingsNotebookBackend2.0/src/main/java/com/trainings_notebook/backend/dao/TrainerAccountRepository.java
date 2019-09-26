package com.trainings_notebook.backend.dao;


import com.trainings_notebook.backend.model.TrainerAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerAccountRepository extends CrudRepository<TrainerAccount, Long> {
}
