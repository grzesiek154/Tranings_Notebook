package com.grzegorz_malarski.trainings_notebook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_role")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long id;


    @Column(name = "role")
    private String role;

    @OneToOne(fetch = FetchType.LAZY)
    private BaseUser user;
}
