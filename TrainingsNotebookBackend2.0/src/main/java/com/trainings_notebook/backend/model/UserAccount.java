package com.trainings_notebook.backend.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "app_users")
public class UserAccount extends BaseAppAccount {

    private String nickname;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private double weight;


    private double height;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Notebook> notebooks = new ArrayList<>();
//
//    @ManyToMany(cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    })
//    @JoinTable(name = "users_calendars",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "calendar_id"))
//    private Set<TrainingsCalendar> calendarsWithTrainings = new HashSet<>();

    public UserAccount addNotebook(Notebook notebook) {
        notebooks.add(notebook);
        notebook.setUser(this);

        return this;
    }



//    public UserAccount(String name, String surname, String email, String password){
//            super(name,surname,email,password);
//            this.notebooks = new ArrayList<>();
//            this.calendarsWithTrainings = new HashSet<>();
//
//    }

}
