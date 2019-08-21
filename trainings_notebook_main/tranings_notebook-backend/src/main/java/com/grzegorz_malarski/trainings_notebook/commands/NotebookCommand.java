package com.grzegorz_malarski.trainings_notebook.commands;

import com.grzegorz_malarski.trainings_notebook.model.UserAccount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class NotebookCommand {

    private Long id;
    private Long userId;
    @NotBlank
    private String name;
    private Set<TrainingCommand> trainings;
    private String note;
}
