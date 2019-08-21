package com.grzegorz_malarski.trainings_notebook.converters.entity_to_command;

import com.grzegorz_malarski.trainings_notebook.commands.TrainingCategoryCommand;
import com.grzegorz_malarski.trainings_notebook.model.TrainingCategory;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TrainingCategoryToCommand implements Converter<TrainingCategory, TrainingCategoryCommand> {

    private final TrainingToCommand trainingToCommandConverter;

    public TrainingCategoryToCommand(TrainingToCommand trainingToCommandConverter) {
        this.trainingToCommandConverter = trainingToCommandConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public TrainingCategoryCommand convert(TrainingCategory source) {

        if (source == null) {
            return null;
        }

        TrainingCategoryCommand trainingCategoryCommand = new TrainingCategoryCommand();
        trainingCategoryCommand.setId(source.getId());
        trainingCategoryCommand.setDescription(source.getDescription());
        if (source.getTrainings() != null && source.getTrainings().size() > 0) {
            source.getTrainings().forEach(training -> trainingCategoryCommand.getTrainings().add(trainingToCommandConverter.convert(training)));
        }

        return trainingCategoryCommand;
    }
}
