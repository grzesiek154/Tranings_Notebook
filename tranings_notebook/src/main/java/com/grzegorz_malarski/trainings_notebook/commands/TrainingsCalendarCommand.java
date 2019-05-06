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
    private Long userId;
    @NotBlank
    private int year;
    @NotBlank
    private String month;
    private Set<TrainingCommand> trainings;


}
