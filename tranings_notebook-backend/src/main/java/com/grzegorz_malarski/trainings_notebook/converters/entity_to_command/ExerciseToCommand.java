package com.grzegorz_malarski.trainings_notebook.converters.entity_to_command;

import com.grzegorz_malarski.trainings_notebook.commands.ExerciseCommand;
import com.grzegorz_malarski.trainings_notebook.model.Exercise;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class ExerciseToCommand implements Converter<Exercise, ExerciseCommand> {

    @Synchronized
    @Nullable
    @Override
    public ExerciseCommand convert(Exercise source) {

        if (source == null) {
            return null;
        }

        ExerciseCommand exerciseCommand = new ExerciseCommand();
        exerciseCommand.setId(source.getId());
        exerciseCommand.setName(source.getName());
        if (source.getReps() > 0) {
            exerciseCommand.setReps(source.getReps());
        }
        if (source.getTime() > 0) {
            exerciseCommand.setTime(source.getTime());
        }
        if (source.getAuthor() != null) {
            exerciseCommand.setAuthorId(source.getAuthor().getId());
        }

        return exerciseCommand;
    }
}
