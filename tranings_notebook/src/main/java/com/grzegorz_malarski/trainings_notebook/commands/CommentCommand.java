package com.grzegorz_malarski.trainings_notebook.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class CommentCommand {

    private Long id;
    private Long authorId;
    private Long postId;
    private LocalDate createDate;
    private String content;
}
