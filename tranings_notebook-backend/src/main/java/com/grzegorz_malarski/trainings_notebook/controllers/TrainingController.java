package com.grzegorz_malarski.trainings_notebook.controllers;

import com.grzegorz_malarski.trainings_notebook.exceptions.NotFoundException;
import com.grzegorz_malarski.trainings_notebook.model.Comment;
import com.grzegorz_malarski.trainings_notebook.model.Post;
import com.grzegorz_malarski.trainings_notebook.model.Training;
import com.grzegorz_malarski.trainings_notebook.services.TrainingService;
import com.grzegorz_malarski.trainings_notebook.services.implementation.TrainingServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/trainings")
public class TrainingController {

    private final TrainingServiceImpl trainingService;

    public TrainingController(TrainingServiceImpl trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping("/all")
    public ResponseEntity<Set<Training>> getAllTrainings() {
        Set<Training> trainings = trainingService.findAll();
        if(trainings.isEmpty()) {
            throw new NotFoundException("Comments not found");
        } else {
            return new ResponseEntity<>(trainings, HttpStatus.OK);
        }
    }

    @GetMapping("/{trainingId}")
    public ResponseEntity<Training> getCommentById(@PathVariable Long trainingId) {

        Training training = trainingService.findById(trainingId);
        if(training == null) {
            throw new NotFoundException("Comment with id:" + trainingId + " not found.");
        }
        return new ResponseEntity<>(training, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Training> save(@RequestBody Training training, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }
        Training savedTraining = trainingService.save(training);
        return new ResponseEntity<>(savedTraining, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{trainingId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> deleteById(@PathVariable Long trainingId) {
        Training training = trainingService.findById(trainingId);

        if(training != null) {
            trainingService.deleteById(trainingId);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
