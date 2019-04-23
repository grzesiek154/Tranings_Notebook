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
    private List<Training> trainingsAdded;

    @OneToMany(
            mappedBy = "author",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Exercise> exercisesAdded;



    public TrainerAccount(String name, String surname, String email, String password) {
        super(name,surname,email,password);
        this.posts = new ArrayList<>();
        this.trainingsAdded = new ArrayList<>();
        this.exercisesAdded = new ArrayList<>();
    }
}
