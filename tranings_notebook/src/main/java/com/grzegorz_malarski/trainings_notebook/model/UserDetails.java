package com.grzegorz_malarski.trainings_notebook.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "user_details_id")
    private int id;

    @Column(name = "birth_date", nullable = true)
    private LocalDate birthDate;

    @Column(name = "weight", nullable = true)
    private double weight;

    @Column(name = "height", nullable = true)
    private double height;

    @OneToOne(fetch =  FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LinkedList<Integer> comments;


}
