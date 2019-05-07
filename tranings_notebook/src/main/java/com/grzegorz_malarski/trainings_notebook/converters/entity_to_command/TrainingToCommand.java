package com.grzegorz_malarski.trainings_notebook.converters.entity_to_command;

import com.grzegorz_malarski.trainings_notebook.commands.TrainingCommand;
import com.grzegorz_malarski.trainings_notebook.model.Training;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TrainingToCommand implements Converter<Training, TrainingCommand> {

    private final TrainingCategoryToCommand trainingCategoryToCommandConverter;
    private final ExerciseToCommand exerciseToCommandConverter;
    private final TrainingsCalendarToCommand trainingsCalendarToCommandConverter;

    public TrainingToCommand(TrainingCategoryToCommand trainingCategoryToCommandConverter, ExerciseToCommand exerciseToCommandConverter, TrainingsCalendarToCommand trainingsCalendarToCommandConverter) {
        this.trainingCategoryToCommandConverter = trainingCategoryToCommandConverter;
        this.exerciseToCommandConverter = exerciseToCommandConverter;
        this.trainingsCalendarToCommandConverter = trainingsCalendarToCommandConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public TrainingCommand convert(Training source) {

        if (source == null) {
            return null;
        }
        TrainingCommand trainingCommand = new TrainingCommand();
        trainingCommand.setId(source.getId());
        if (source.getAuthor() != null) {
            trainingCommand.setAuthorId(source.getAuthor().getId());
        }
        trainingCommand.setName(source.getName());
        trainingCommand.setDescription(source.getDescription());
        if(source.getCategories() != null && source.getCategories().size() > 0) {
            source.getCategories().forEach(trainingCategory -> trainingCommand.getCategories().add(trainingCategoryToCommandConverter.convert(trainingCategory)));
        }
        if(source.getExercises() != null && source.getExercises().size() > 0) {
            source.getExercises().forEach(exercise -> trainingCommand.getExercises().add(exerciseToCommandConverter.convert(exercise)));
        }
        if(source.getTrainingsInCalendar() != null && source.getTrainingsInCalendar().size() > 0) {
            source.getTrainingsInCalendar().forEach(trainingsCalendar -> trainingCommand.getTrainingsCalendars().add(trainingsCalendarToCommandConverter.convert(trainingsCalendar)));
        }



        return trainingCommand;
    }

}
