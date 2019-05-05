package com.grzegorz_malarski.trainings_notebook.converters.command_to_entity;

import com.grzegorz_malarski.trainings_notebook.commands.ExerciseCategoryCommand;
import com.grzegorz_malarski.trainings_notebook.model.ExerciseCategory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExerciseCategoryCommandToEntity implements Converter<ExerciseCategoryCommand, ExerciseCategory> {


    private final ExerciseCommandToEntity exerciseConverter;

    public ExerciseCategoryCommandToEntity(ExerciseCommandToEntity exerciseConverter) {
        this.exerciseConverter = exerciseConverter;
    }

    @Override
    public ExerciseCategory convert(ExerciseCategoryCommand source) {

        if (source == null) {
            return null;
        }

        final ExerciseCategory exerciseCategory = new ExerciseCategory();
        exerciseCategory.setId(source.getId());
        exerciseCategory.setDescription(source.getDescription());
        if (source.getExercises() != null && source.getExercises().size() > 0) {
            source.getExercises().forEach(exerciseCommand -> exerciseCategory.getExercises().add(exerciseConverter.convert(exerciseCommand)));
        }

        return exerciseCategory;
    }
}
