package com.grzegorz_malarski.trainings_notebook.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class TrainingsCalendarCommand {

    private Long id;
    @NotBlank
    private int year;
    private Set<TrainingCommand> trainings;


}
