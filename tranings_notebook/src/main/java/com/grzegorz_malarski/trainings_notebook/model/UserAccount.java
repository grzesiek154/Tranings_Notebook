package com.grzegorz_malarski.trainings_notebook.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Data

@NoArgsConstructor
@Entity
@Table(name = "app_users")
public class UserAccount extends BaseAppAccount {


    @Column(name = "birth_date", nullable = true)
    private LocalDate birthDate;


    private double weight;


    private double height;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Notebook> notebooks;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "users_calendars",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "calendar_id"))
    private Set<TrainingsCalendar> calendarsWithTrainings;




    public UserAccount(String name, String surname, String email, String password){
            super(name,surname,email,password);
            this.notebooks = new ArrayList<>();
            this.calendarsWithTrainings = new HashSet<>();

    }

}
