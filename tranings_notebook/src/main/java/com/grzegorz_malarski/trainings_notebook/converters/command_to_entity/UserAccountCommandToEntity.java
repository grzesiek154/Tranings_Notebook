package com.grzegorz_malarski.trainings_notebook.converters.command_to_entity;

import com.grzegorz_malarski.trainings_notebook.commands.UserAccountCommand;
import com.grzegorz_malarski.trainings_notebook.model.UserAccount;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserAccountCommandToEntity implements Converter<UserAccountCommand, UserAccount> {

    private final NotebookCommandToEntity notebookCommandConverter;
    private final TrainingsCalendarCommandToEntity trainingsCalendarCommandConverter;

    public UserAccountCommandToEntity(NotebookCommandToEntity notebookCommandConverter, TrainingsCalendarCommandToEntity trainingsCalendarCommandConverter) {
        this.notebookCommandConverter = notebookCommandConverter;
        this.trainingsCalendarCommandConverter = trainingsCalendarCommandConverter;
    }

    @Override
    public UserAccount convert(UserAccountCommand source) {
        if (source == null) {
            return null;
        }

        UserAccount user = new UserAccount();
        user.setId(source.getId());
        user.setNickname(source.getNickname());
        user.setBirthDate(source.getBirthDate());
        user.setWeight(source.getWeight());
        user.setHeight(source.getHeight());

        if (source.getNotebooks() != null && source.getNotebooks().size() > 0) {
            source.getNotebooks().forEach(notebookCommand -> user.getNotebooks().add(notebookCommandConverter.convert(notebookCommand)));
        }

        if (source.getCalendarsWithTrainings() != null && source.getCalendarsWithTrainings().size() > 0) {
            source.getCalendarsWithTrainings().forEach(calendarCommand -> user.getCalendarsWithTrainings().add(trainingsCalendarCommandConverter.convert(calendarCommand)));
        }

        return user;
    }
}
