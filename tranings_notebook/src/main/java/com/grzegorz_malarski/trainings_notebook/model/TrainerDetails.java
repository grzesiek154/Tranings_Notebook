package com.grzegorz_malarski.trainings_notebook.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trainer_details")
public class TrainerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trainer_details_id")
    private Long id;

    @Column(name = "specialization")
    private String specialization;

    private LinkedList<Integer> posts;

    private LinkedList<Integer> comments;

    private LinkedList<Training> trainingsAdded;

    private LinkedList<Exercise> exercisesAdded;
}
