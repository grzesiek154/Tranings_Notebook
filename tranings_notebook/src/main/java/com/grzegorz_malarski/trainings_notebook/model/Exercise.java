package com.grzegorz_malarski.trainings_notebook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exercise_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "reps")
    private int reps;

    @Column(name = "duration")
    private double time;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "exercises")
    private Set<Training> trainings = new HashSet<>();
}
