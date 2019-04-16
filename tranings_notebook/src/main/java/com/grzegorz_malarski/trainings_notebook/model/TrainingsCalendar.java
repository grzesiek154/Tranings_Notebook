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
@Table(name = "calendar")
public class TrainingsCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "calendar_id")
    private Long id;

    @Column(name = "month")
    private String month;

    @Column(name = "year")
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
    private Set<AppUserAccount> users = new HashSet<>();

    //private static final Month[] MONTHS = Month.values();


}
