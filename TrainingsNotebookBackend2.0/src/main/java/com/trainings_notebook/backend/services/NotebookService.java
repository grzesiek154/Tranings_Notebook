package com.trainings_notebook.backend.services;


import com.trainings_notebook.backend.model.Notebook;
import org.springframework.stereotype.Service;

import java.util.List;


public interface NotebookService extends CrudService<Notebook,Long>{

    Notebook findByName(String name);
    List<String> getAllUserNotebooks(Long id);

}
