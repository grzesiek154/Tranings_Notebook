package com.grzegorz_malarski.trainings_notebook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trainers")
public class TrainerAccount extends BaseUser{


    @Column(name = "specialization")
    private String specialization;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();


//    private List<Training> trainingsAdded = new ArrayList<>();
//
//    private List<Exercise> exercisesAdded = new ArrayList<>();
}
