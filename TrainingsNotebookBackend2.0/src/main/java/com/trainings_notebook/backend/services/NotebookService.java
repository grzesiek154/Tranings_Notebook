package com.trainings_notebook.backend.services;


import com.trainings_notebook.backend.model.Notebook;
import org.springframework.stereotype.Service;


public interface NotebookService extends CrudService<Notebook,Long>{

    Notebook findByName(String name);

}
