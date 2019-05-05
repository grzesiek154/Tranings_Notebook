package com.grzegorz_malarski.trainings_notebook.converters.command_to_entity;

import com.grzegorz_malarski.trainings_notebook.commands.ExerciseCommand;
import com.grzegorz_malarski.trainings_notebook.model.Exercise;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class ExerciseCommandToEntity implements Converter<ExerciseCommand, Exercise> {

    private final ExerciseCategoryCommandToEntity exerciseCategoryConverter;

    public ExerciseCommandToEntity(ExerciseCategoryCommandToEntity exerciseCategoryConverter) {
        this.exerciseCategoryConverter = exerciseCategoryConverter;
    }

    @Override
    public Exercise convert(ExerciseCommand source) {

        if (source == null) {
            return null;
        }
        final Exercise exercise = new Exercise();
        exercise.setId(source.getId());
        exercise.setName(source.getName());
        if (source.getCategories() != null && source.getCategories().size() > 0) {
            source.getCategories().forEach(exerciseCategoryCommand -> exercise.getCategories().add(exerciseCategoryConverter.convert(exerciseCategoryCommand)));
        }
        return exercise;
    }
}
