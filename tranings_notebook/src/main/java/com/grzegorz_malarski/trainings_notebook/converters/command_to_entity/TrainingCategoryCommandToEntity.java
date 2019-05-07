package com.grzegorz_malarski.trainings_notebook.converters.command_to_entity;

import com.grzegorz_malarski.trainings_notebook.commands.TrainingCategoryCommand;
import com.grzegorz_malarski.trainings_notebook.model.TrainingCategory;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TrainingCategoryCommandToEntity implements Converter<TrainingCategoryCommand, TrainingCategory> {

    private final TrainingComandToEntity trainingComandConverter;

    public TrainingCategoryCommandToEntity(TrainingComandToEntity trainingComandConverter) {
        this.trainingComandConverter = trainingComandConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public TrainingCategory convert(TrainingCategoryCommand source) {

        if (source == null) {
            return null;
        }

        TrainingCategory trainingCategory = new TrainingCategory();
        trainingCategory.setId(source.getId());
        trainingCategory.setDescription(source.getDescription());
        if(source.getTrainings() != null && source.getTrainings().size() > 0) {
            source.getTrainings().forEach(trainingCommand -> trainingCategory.getTrainings().add(trainingComandConverter.convert(trainingCommand)));
        }
        return trainingCategory;

    }
}
