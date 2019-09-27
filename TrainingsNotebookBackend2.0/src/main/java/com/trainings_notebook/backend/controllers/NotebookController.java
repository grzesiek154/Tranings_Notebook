package com.trainings_notebook.backend.controllers;

import com.trainings_notebook.backend.model.Notebook;
import com.trainings_notebook.backend.services.NotebookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("api/notebooks")
public class NotebookController {

    private final NotebookService notebookService;


    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }


    @GetMapping(value = "/byId/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Notebook> getById(@PathVariable Long id) {

        Notebook notebook = notebookService.findById(id);

        if(notebook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(notebook,HttpStatus.OK);
    }


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Notebook>> getAllNotebooks() {

        Collection<Notebook> notebooks = notebookService.findAll();
        if(notebooks.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(notebooks, HttpStatus.OK);
    }

    @GetMapping(value = "/byName", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Notebook> getNotebookByName(@PathVariable String name) {

        Notebook notebook = notebookService.findByName(name);
        if(notebook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(notebook,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Notebook> save(@RequestBody @Valid Notebook notebook, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(notebook, HttpStatus.BAD_REQUEST);
        }
        notebookService.save(notebook);
        return new ResponseEntity<>(notebook, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Notebook> delete(@RequestBody @Valid Notebook notebook, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(notebook, HttpStatus.BAD_REQUEST);
        }
        notebookService.delete(notebook);
        return new ResponseEntity<>(notebook, HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteById/{id}")
    public ResponseEntity<Notebook> delete(@PathVariable Long id) {

        Notebook notebook = notebookService.findById(id);
        if(notebook == null) {
            return new ResponseEntity<>(notebook, HttpStatus.NOT_FOUND);
        }
        notebookService.delete(notebook);
        return new ResponseEntity<>(notebook, HttpStatus.NO_CONTENT);
    }
}
