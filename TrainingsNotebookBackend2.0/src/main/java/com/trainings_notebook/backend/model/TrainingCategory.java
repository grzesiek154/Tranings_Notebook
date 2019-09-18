package com.trainings_notebook.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trainings_categories")
public class TrainingCategory {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "category_id")
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Training> trainings = new HashSet<>();


}
