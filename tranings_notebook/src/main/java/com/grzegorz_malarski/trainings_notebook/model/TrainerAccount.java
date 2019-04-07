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
@Table(name = "trainers")
public class TrainerAccount {

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "appUserAccount", cascade = CascadeType.ALL, optional = true)
    private TrainerDetails trainerDetails;
}
