package com.grzegorz_malarski.trainings_notebook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
}
