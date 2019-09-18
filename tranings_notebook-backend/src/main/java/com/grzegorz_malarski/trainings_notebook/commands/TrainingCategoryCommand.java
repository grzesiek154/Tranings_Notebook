package com.grzegorz_malarski.trainings_notebook.commands;

import com.grzegorz_malarski.trainings_notebook.model.Training;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class TrainingCategoryCommand {

    private Long id;
    private String description;
    private Set<TrainingCommand> trainings = new HashSet<>();
}
