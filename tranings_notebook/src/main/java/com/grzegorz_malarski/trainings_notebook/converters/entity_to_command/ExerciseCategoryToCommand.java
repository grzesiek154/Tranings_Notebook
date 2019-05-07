package com.grzegorz_malarski.trainings_notebook.converters.entity_to_command;

import com.grzegorz_malarski.trainings_notebook.commands.ExerciseCategoryCommand;
import com.grzegorz_malarski.trainings_notebook.model.ExerciseCategory;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ExerciseCategoryToCommand implements Converter<ExerciseCategory, ExerciseCategoryCommand> {

    private final ExerciseToCommand exerciseToCommandConverter;

    public ExerciseCategoryToCommand(ExerciseToCommand exerciseToCommandConverter) {
        this.exerciseToCommandConverter = exerciseToCommandConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public ExerciseCategoryCommand convert(ExerciseCategory source) {

        if(source == null) {
            return null;
        }

        ExerciseCategoryCommand exerciseCategoryCommand = new ExerciseCategoryCommand();
        exerciseCategoryCommand.setDescription(source.getDescription());

        if(source.getExercises() != null && source.getExercises().size() > 0) {
            source.getExercises().forEach(exercise -> exerciseCategoryCommand.getExercises().add(exerciseToCommandConverter.convert(exercise)));
        }


        return exerciseCategoryCommand;
    }
}
