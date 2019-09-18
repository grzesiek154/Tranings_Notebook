package com.grzegorz_malarski.trainings_notebook.controllers;

import com.grzegorz_malarski.trainings_notebook.exceptions.NotFoundException;
import com.grzegorz_malarski.trainings_notebook.model.Comment;
import com.grzegorz_malarski.trainings_notebook.model.Notebook;
import com.grzegorz_malarski.trainings_notebook.model.Post;
import com.grzegorz_malarski.trainings_notebook.services.implementation.NotebookServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/notebooks")
public class NotebookController {

    private final NotebookServiceImpl notebookService;

    public NotebookController(NotebookServiceImpl notebookService) {
        this.notebookService = notebookService;
    }

    @GetMapping("/all")
    public ResponseEntity<Set<Notebook>> getAllNotebooks() {
        Set<Notebook> notebooks = notebookService.findAll();
        if(notebooks.isEmpty()) {
            throw new NotFoundException("Notebooks not found");
        } else {
            return new ResponseEntity<>(notebooks, HttpStatus.OK);
        }
    }


    @GetMapping("/{notebookId}")
    public ResponseEntity<Notebook> getNotebookById(@PathVariable Long notebookId) {

        Notebook notebook = notebookService.findById(notebookId);
        if(notebook == null) {
            throw new NotFoundException("Comment with id:" + notebookId + " not found.");
        }
        return new ResponseEntity<>(notebook, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Notebook> save(@RequestBody Notebook notebook, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }
        Notebook savedNotebook = notebookService.save(notebook);
        return new ResponseEntity<>(savedNotebook, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{notebookId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> deleteById(@PathVariable Long notebookId) {
        Notebook notebook = notebookService.findById(notebookId);

        if(notebook != null) {
            notebookService.deleteById(notebookId);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
