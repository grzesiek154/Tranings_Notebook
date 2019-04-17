package com.grzegorz_malarski.trainings_notebook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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


    @NotBlank
    private String role;

    @OneToOne(fetch = FetchType.LAZY)
    private BaseUser user;
}
