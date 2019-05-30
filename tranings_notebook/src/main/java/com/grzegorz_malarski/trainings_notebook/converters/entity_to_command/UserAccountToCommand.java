package com.grzegorz_malarski.trainings_notebook.converters.entity_to_command;

import com.grzegorz_malarski.trainings_notebook.commands.UserAccountCommand;
import com.grzegorz_malarski.trainings_notebook.model.UserAccount;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserAccountToCommand implements Converter<UserAccount, UserAccountCommand> {

    private final NotebookToCommand notebookToCommandConverter;
    private final CommentToCommand commentToCommandConverter;


    public UserAccountToCommand(NotebookToCommand notebookToCommandConverter, CommentToCommand commentToCommandConverter) {
        this.notebookToCommandConverter = notebookToCommandConverter;
        this.commentToCommandConverter = commentToCommandConverter;

    }

    @Synchronized
    @Nullable
    @Override
    public UserAccountCommand convert(UserAccount source) {

        if(source == null) {
            return null;
        }

        UserAccountCommand userAccountCommand = new UserAccountCommand();
        userAccountCommand.setId(source.getId());
        userAccountCommand.setName(source.getName());
        userAccountCommand.setSurname(source.getSurname());
        userAccountCommand.setNickname(source.getNickname());
        userAccountCommand.setEmail(source.getEmail());
        userAccountCommand.setBirthDate(source.getBirthDate());
        userAccountCommand.setHeight(source.getHeight());
        userAccountCommand.setWeight(source.getWeight());

        if(source.getNotebooks() != null && source.getNotebooks(). size()>0) {
            source.getNotebooks().forEach(notebook -> userAccountCommand.getNotebooks().add(notebookToCommandConverter.convert(notebook)));
        }
        if(source.getComments() != null && source.getComments().size() > 0) {
            source.getComments().forEach(comment -> userAccountCommand.getComments().add(commentToCommandConverter.convert(comment)));
        }


        return userAccountCommand;
    }
}
