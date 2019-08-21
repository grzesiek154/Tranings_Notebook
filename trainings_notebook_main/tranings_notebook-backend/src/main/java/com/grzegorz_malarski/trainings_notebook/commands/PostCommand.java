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

    @NotBlank
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private Long authorId;
    @NotBlank
    private LocalDate createDate;
    @NotBlank
    private String content;
    private List<CommentCommand> comments;
}
