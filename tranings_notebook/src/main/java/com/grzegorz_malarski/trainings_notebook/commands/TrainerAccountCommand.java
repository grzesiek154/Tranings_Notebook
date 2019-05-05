package com.grzegorz_malarski.trainings_notebook.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class TrainerAccountCommand {

    private String specialization;
    private List<TrainingCommand> trainings;
    private List<ExerciseCommand> exercises;
}
