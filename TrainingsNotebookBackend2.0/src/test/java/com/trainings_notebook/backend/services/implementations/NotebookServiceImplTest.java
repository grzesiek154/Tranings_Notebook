package com.trainings_notebook.backend.services.implementations;

import com.trainings_notebook.backend.dao.NotebookRepository;
import com.trainings_notebook.backend.model.Notebook;
import com.trainings_notebook.backend.services.NotebookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NotebookServiceImplTest {

    @Mock
    private NotebookRepository notebookRepository;
    private NotebookService notebookService;

    Notebook notebook = new Notebook();

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
        notebookService = new NotebookServiceImpl(notebookRepository);

        notebook.setName("cardio training");
        notebook.setId(1L);
    }

    @Test
    void findByName() {


        Optional<Notebook> notebookOptional = Optional.of(notebook);

        when(notebookRepository.findByName(anyString())).thenReturn(notebookOptional);

        Notebook notebookFound = notebookService.findByName("cardio training");

        assertNotNull( notebookFound, "null notebook found");
        verify(notebookRepository, times(1)).findByName(anyString());
        verify(notebookRepository, never()).findAll();
    }

    @Test
    void getAllUserNotebooks() {
        Optional<Notebook> notebookOptional = Optional.of(notebook);
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(notebook);

        Notebook notebook2 = new Notebook();
        notebook2.setName("strength training");

        notebooks.add(notebook2);

        when(notebookRepository.findAll()).thenReturn(notebooks);
        assertEquals(2, notebooks.size());
        verify(notebookRepository, times(1)).findAll();

    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}