package com.grzegorz_malarski.trainings_notebook.commands;

import com.grzegorz_malarski.trainings_notebook.model.TrainerAccount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class ExerciseCommand {

    private Long id;
    @NotBlank
    private String name;
    private TrainerAccount author;
    private int reps;
    private double time;
    @NotBlank
    private String description;
    private Set<ExerciseCategoryCommand> categories = new HashSet<>();

}
