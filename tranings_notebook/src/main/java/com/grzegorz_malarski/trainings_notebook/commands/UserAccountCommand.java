package com.grzegorz_malarski.trainings_notebook.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class UserAccountCommand {

    private String nickname;
    private LocalDate birthDate;
    private double weight;
    private double height;
    private List<NotebookCommand> notebooks;
    private Set<TrainingsCalendarCommand> calendarsWithTrainings;
}
