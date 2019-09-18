package com.grzegorz_malarski.trainings_notebook.services;

import com.grzegorz_malarski.trainings_notebook.model.Notebook;

public interface NotebookService extends CrudService<Notebook,Long>{

    Notebook findByName(String name);
}
