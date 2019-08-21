package com.grzegorz_malarski.trainings_notebook.converters.command_to_entity;

import com.grzegorz_malarski.trainings_notebook.commands.ExerciseCategoryCommand;
import com.grzegorz_malarski.trainings_notebook.model.ExerciseCategory;
import com.grzegorz_malarski.trainings_notebook.model.TrainerAccount;
import com.grzegorz_malarski.trainings_notebook.model.Training;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExerciseCategoryCommandToEntity implements Converter<ExerciseCategoryCommand, ExerciseCategory> {




    @Override
    public ExerciseCategory convert(ExerciseCategoryCommand source) {

        if (source == null) {
            return null;
        }

        final ExerciseCategory exerciseCategory = new ExerciseCategory();
        exerciseCategory.setId(source.getId());
        exerciseCategory.setDescription(source.getDescription());

        return exerciseCategory;
    }
}
