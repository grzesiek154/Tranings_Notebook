package com.trainings_notebook.backend.services.implementations;

import com.trainings_notebook.backend.dao.NotebookRepository;
import com.trainings_notebook.backend.model.Notebook;
import com.trainings_notebook.backend.services.NotebookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class NotebookServiceImpl implements NotebookService {

    private final NotebookRepository notebookRepository;

    public NotebookServiceImpl(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }


    @Override
    public Notebook findByName(String name) {

        return notebookRepository.findByName(name).orElse(null);
    }

    @Override
    public List<String> getAllUserNotebooks(Long id) {

        List<Notebook> notebooks = new ArrayList<>();


        return null;
    }

    @Override
    public Set<Notebook> findAll() {
        Set<Notebook> notebooks = new HashSet<>();
        notebookRepository.findAll().forEach(notebooks::add);

        return notebooks;
    }

    @Override
    public Notebook findById(Long id) {
        return notebookRepository.findById(id).orElse(null);
    }

    @Override
    public Notebook save(Notebook notebook) {
        return notebookRepository.save(notebook);

    }

    @Override
    public void delete(Notebook notebook) {
        notebookRepository.delete(notebook);
    }

    @Override
    public void deleteById(Long id) {
        notebookRepository.deleteById(id);
    }


}
