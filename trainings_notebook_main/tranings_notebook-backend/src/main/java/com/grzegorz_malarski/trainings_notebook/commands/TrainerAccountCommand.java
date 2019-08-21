package com.grzegorz_malarski.trainings_notebook.commands;

import com.grzegorz_malarski.trainings_notebook.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class TrainerAccountCommand extends BaseAppAccountCommand {

    private String specialization;
    private List<TrainingCommand> trainings = new ArrayList<>();
    private List<ExerciseCommand> exercises = new ArrayList<>();
    private List<PostCommand> posts;
}
