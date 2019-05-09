package com.grzegorz_malarski.trainings_notebook.converters.entity_to_command;

import com.grzegorz_malarski.trainings_notebook.commands.ExerciseCategoryCommand;
import com.grzegorz_malarski.trainings_notebook.model.ExerciseCategory;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ExerciseCategoryToCommand implements Converter<ExerciseCategory, ExerciseCategoryCommand> {

    @Synchronized
    @Nullable
    @Override
    public ExerciseCategoryCommand convert(ExerciseCategory source) {

        if(source == null) {
            return null;
        }

        ExerciseCategoryCommand exerciseCategoryCommand = new ExerciseCategoryCommand();
        exerciseCategoryCommand.setDescription(source.getDescription());


        return exerciseCategoryCommand;
    }
}
