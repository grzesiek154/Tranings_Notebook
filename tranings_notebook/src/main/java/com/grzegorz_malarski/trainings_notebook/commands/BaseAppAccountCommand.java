package com.grzegorz_malarski.trainings_notebook.commands;

import com.grzegorz_malarski.trainings_notebook.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class BaseAppAccountCommand {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private LocalDate joinDate;
    private Role role;
    private List<CommentCommand> comments = new ArrayList<>();


}
