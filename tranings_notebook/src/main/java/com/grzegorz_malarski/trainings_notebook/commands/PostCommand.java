package com.grzegorz_malarski.trainings_notebook.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PostCommand {

    private Long id;
    private String title;
    private TrainerAccountCommand author;
    @NotBlank
    private LocalDate createDate;
    @NotBlank
    private String content;
    private List<CommentCommand> comments;
}
