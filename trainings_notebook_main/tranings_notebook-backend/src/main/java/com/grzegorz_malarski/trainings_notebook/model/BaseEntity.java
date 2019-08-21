package com.grzegorz_malarski.trainings_notebook.model;

import lombok.Data;

import javax.persistence.*;



@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
