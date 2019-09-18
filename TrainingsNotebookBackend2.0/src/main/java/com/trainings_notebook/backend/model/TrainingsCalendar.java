package com.trainings_notebook.backend.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;


public class TrainingsCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "calendar_id")
    private Long id;

    @NotBlank
    private String month;

    @NotBlank
    private int year;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "calendar_trainings",
            joinColumns = @JoinColumn(name = "calendar_id"),
            inverseJoinColumns = @JoinColumn(name = "training_id"))
    private Set<Training> trainings = new HashSet<>();

    @ManyToMany(mappedBy = "calendarsWithTrainings")
    private UserAccount user;

//    public TrainingsCalendar addTrainingToCalendar(Training training) {
//        training.getTrainingsInCalendar().add(this);
//        this.trainings.add(training);
//
//        return this;
//    }

}
