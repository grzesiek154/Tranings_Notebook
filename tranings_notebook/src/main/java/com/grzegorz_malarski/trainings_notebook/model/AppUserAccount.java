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
import java.util.*;

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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Notebook> notebooks = new ArrayList<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "users_calendars",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "calendar_id"))
    private Set<TrainingsCalendar> calendarsWithTrainings = new HashSet<>();

}
