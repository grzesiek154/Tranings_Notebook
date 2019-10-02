package com.trainings_notebook.backend.controllers;

import com.trainings_notebook.backend.model.Notebook;
import com.trainings_notebook.backend.model.Training;
import com.trainings_notebook.backend.services.TrainingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("api/trainings")
public class TrainingController {

    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping(value = "/byId/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Training> getById(@PathVariable Long id) {

        Training training = trainingService.findById(id);

        if(training == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(training,HttpStatus.OK);
    }


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Training>> getAllTrainings() {

        Collection<Training> trainings = trainingService.findAll();
        if(trainings.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(trainings, HttpStatus.OK);
    }

    @GetMapping(value = "/byName/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Training> getTrainingByName(@PathVariable String name) {

        Training training = trainingService.findByName(name);
        if(training == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(training,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Training> save(@RequestBody @Valid Training training, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(training, HttpStatus.BAD_REQUEST);
        }
        trainingService.save(training);
        return new ResponseEntity<>(training, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody @Valid Training training, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        trainingService.delete(training);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteById/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        Training training = trainingService.findById(id);
        if(training == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        trainingService.delete(training);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
