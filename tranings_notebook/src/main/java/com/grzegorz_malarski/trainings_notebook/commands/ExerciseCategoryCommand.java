package com.grzegorz_malarski.trainings_notebook.commands;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class ExerciseCategoryCommand {

    private Long id;
    private String description;

}
