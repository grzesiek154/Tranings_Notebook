package com.trainings_notebook.backend.dao;

import com.grzegorz_malarski.trainings_notebook.model.Notebook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotebookRepository extends CrudRepository<Notebook, Long> {
}
