package com.grzegorz_malarski.trainings_notebook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class AppUserAccount extends BaseUser {


    @Column(name = "birth_date", nullable = true)
    private LocalDate birthDate;

    @Column(name = "weight", nullable = true)
    private double weight;

    @Column(name = "height", nullable = true)
    private double height;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();




}
