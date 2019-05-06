package com.grzegorz_malarski.trainings_notebook.converters.command_to_entity;

import com.grzegorz_malarski.trainings_notebook.commands.TrainingsCalendarCommand;
import com.grzegorz_malarski.trainings_notebook.model.TrainingsCalendar;
import com.grzegorz_malarski.trainings_notebook.model.UserAccount;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TrainingsCalendarCommandToEntity implements Converter<TrainingsCalendarCommand, TrainingsCalendar> {

    private final TrainingComandToEntity trainingComandConverter;

    public TrainingsCalendarCommandToEntity(TrainingComandToEntity trainingComandConverter) {
        this.trainingComandConverter = trainingComandConverter;
    }

    @Override
    public TrainingsCalendar convert(TrainingsCalendarCommand source) {

        if (source == null) {
            return null;
        }

        final TrainingsCalendar trainingsCalendar = new TrainingsCalendar();
        trainingsCalendar.setId(source.getId());
        trainingsCalendar.setMonth(source.getMonth());
        trainingsCalendar.setYear(source.getYear());
        UserAccount user = new UserAccount();
        user.setId(source.getId());
        trainingsCalendar.setUser(user);
        if (source.getTrainings() != null && source.getTrainings().size() > 0) {
            source.getTrainings().forEach(trainingCommand -> trainingsCalendar.getTrainings().add(trainingComandConverter.convert(trainingCommand)));
        }
        return trainingsCalendar;
    }
}
