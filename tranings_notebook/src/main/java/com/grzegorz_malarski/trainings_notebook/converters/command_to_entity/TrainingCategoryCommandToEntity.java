package com.grzegorz_malarski.trainings_notebook.converters.command_to_entity;

import com.grzegorz_malarski.trainings_notebook.commands.TrainingCategoryCommand;
import com.grzegorz_malarski.trainings_notebook.model.TrainingCategory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TrainingCategoryCommandToEntity implements Converter<TrainingCategoryCommand, TrainingCategory> {
    @Override
    public TrainingCategory convert(TrainingCategoryCommand source) {
        return null;
    }
}
