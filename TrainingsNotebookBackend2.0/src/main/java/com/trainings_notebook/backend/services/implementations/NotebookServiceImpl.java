package com.trainings_notebook.backend.services.implementations;

import com.trainings_notebook.backend.dao.NotebookRepository;
import com.trainings_notebook.backend.model.Notebook;
import com.trainings_notebook.backend.services.NotebookService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class NotebookServiceImpl implements NotebookService {

    private final NotebookRepository notebookRepository;

    public NotebookServiceImpl(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }


    @Override
    public Notebook findByName(String name) {
        return null;
    }

    @Override
    public Set<Notebook> findAll() {
        return null;
    }

    @Override
    public Notebook findById(Long aLong) {
        return null;
    }

    @Override
    public Notebook save(Notebook object) {
        return null;
    }

    @Override
    public void delete(Notebook object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
