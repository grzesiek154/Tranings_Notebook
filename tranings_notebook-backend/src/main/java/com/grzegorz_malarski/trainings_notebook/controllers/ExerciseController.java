package com.grzegorz_malarski.trainings_notebook.controllers;

import com.grzegorz_malarski.trainings_notebook.exceptions.NotFoundException;
import com.grzegorz_malarski.trainings_notebook.model.Exercise;
import com.grzegorz_malarski.trainings_notebook.services.implementation.ExerciseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.Set;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    private final ExerciseServiceImpl exerciseService;

    public ExerciseController(ExerciseServiceImpl exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/all")
    public ResponseEntity<Set<Exercise>> getAllExercises() {
        Set<Exercise> exercises = exerciseService.findAll();
        if(exercises.isEmpty()) {
            throw new NotFoundException("Comments not found");
        } else {
            return new ResponseEntity<>(exercises, HttpStatus.OK);
        }
    }


    @GetMapping("/{exerciseId}")
    public ResponseEntity<Exercise> getCommentById(@PathVariable Long exerciseId) {

        Exercise exercise = exerciseService.findById(exerciseId);
        if(exercise == null) {
            throw new NotFoundException("Comment with id:" + exerciseId + " not found.");
        }
        return new ResponseEntity<>(exercise, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Exercise> save(@RequestBody Exercise exercise, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }
        Exercise savedExercise = exerciseService.save(exercise);
        return new ResponseEntity<>(savedExercise, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{exerciseId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> deleteById(@PathVariable Long exerciseId) {
        Exercise exercise = exerciseService.findById(exerciseId);

        if(exercise != null) {
            exerciseService.deleteById(exerciseId);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
