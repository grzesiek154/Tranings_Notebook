package com.trainings_notebook.backend.dao;


import com.trainings_notebook.backend.model.Notebook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotebookRepository extends CrudRepository<Notebook, Long> {

    Optional<Notebook> findByName(String name);
}
