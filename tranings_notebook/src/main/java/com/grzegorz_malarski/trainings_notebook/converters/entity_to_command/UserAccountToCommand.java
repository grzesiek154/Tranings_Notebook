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
    private final TrainingsCalendarToCommand trainingsCalendarToCommandConverter;

    public UserAccountToCommand(NotebookToCommand notebookToCommandConverter, CommentToCommand commentToCommandConverter, TrainingsCalendarToCommand trainingsCalendarToCommandConverter) {
        this.notebookToCommandConverter = notebookToCommandConverter;
        this.commentToCommandConverter = commentToCommandConverter;
        this.trainingsCalendarToCommandConverter = trainingsCalendarToCommandConverter;
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
        if(source.getCalendarsWithTrainings() != null && source.getCalendarsWithTrainings().size() > 0) {
            source.getCalendarsWithTrainings().forEach(trainingsCalendar -> userAccountCommand.getCalendarsWithTrainings().add(trainingsCalendarToCommandConverter.convert(trainingsCalendar)));
        }

        return userAccountCommand;
    }
}
