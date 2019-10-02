package com.trainings_notebook.backend.controllers;

import com.trainings_notebook.backend.model.Exercise;
import com.trainings_notebook.backend.services.ExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping(value = "byId/{id}")
    public ResponseEntity<Exercise> getById(@PathVariable Long id) {

        Exercise exercise = exerciseService.findById(id);
        if(exercise == null) {
            return new ResponseEntity<>(exercise, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(exercise, HttpStatus.OK);
    }

    @GetMapping(value = "byName/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Exercise> getByName(@PathVariable String name) {

        Exercise exercise = exerciseService.findByName(name);
        if(exercise == null) {
            return new ResponseEntity<>(exercise, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(exercise, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Exercise> save(@RequestBody @Valid Exercise exercise, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(exercise, HttpStatus.BAD_REQUEST);
        }
        exerciseService.save(exercise);

        return new ResponseEntity<>(exercise, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody @Valid Exercise exercise, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        exerciseService.delete(exercise);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        Exercise exercise = exerciseService.findById(id);
        if(exercise == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
