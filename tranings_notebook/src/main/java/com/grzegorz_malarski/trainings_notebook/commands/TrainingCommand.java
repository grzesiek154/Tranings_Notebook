package com.grzegorz_malarski.trainings_notebook.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class TrainingCommand {

    private Long id;
    private Long authorId;
    @NotBlank
    private String name;
    private String description;
    private Set<TrainingCategoryCommand> categories;
    private Set<ExerciseCommand> exercises;
}
