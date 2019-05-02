package com.grzegorz_malarski.trainings_notebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notebooks")
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "notebook_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserAccount user;


    @NotBlank
    private String name;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "notebook_trainings",
            joinColumns = @JoinColumn(name = "notebook_id"),
            inverseJoinColumns = @JoinColumn(name = "training_id"))
    private Set<Training> trainings = new HashSet<>();


    private String note;

    public Notebook addTraining(Training training) {

        this.trainings.add(training);

        return this;
    }
}
