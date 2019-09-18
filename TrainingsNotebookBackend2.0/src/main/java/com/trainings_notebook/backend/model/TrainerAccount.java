package com.trainings_notebook.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trainers")
public class TrainerAccount extends BaseAppAccount {



    private String specialization;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Post> posts;


    @OneToMany(
            mappedBy = "author",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Training> trainingsAdded = new ArrayList<>();

    @OneToMany(
            mappedBy = "author",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Exercise> exercisesAdded = new ArrayList<>();


    public TrainerAccount addTraining(Training training) {
        training.setAuthor(this);
        this.trainingsAdded.add(training);
        return this;
    }

    public TrainerAccount addExercise(Exercise exercise) {
        exercise.setAuthor(this);
        this.exercisesAdded.add(exercise);
        return this;
    }
}
