package com.grzegorz_malarski.trainings_notebook.converters.command_to_entity;

import com.grzegorz_malarski.trainings_notebook.commands.TrainingCommand;
import com.grzegorz_malarski.trainings_notebook.model.TrainerAccount;
import com.grzegorz_malarski.trainings_notebook.model.Training;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TrainingComandToEntity implements Converter<TrainingCommand, Training> {

    private final TrainingCategoryCommandToEntity trainingCategoryCommandConverter;
    private final ExerciseCommandToEntity exerciseCommandConverter;


    public TrainingComandToEntity(TrainingCategoryCommandToEntity trainingCategoryCommandConverter, ExerciseCommandToEntity exerciseCommandConverter) {
        this.trainingCategoryCommandConverter = trainingCategoryCommandConverter;
        this.exerciseCommandConverter = exerciseCommandConverter;


    }

    @Override
    public Training convert(TrainingCommand source) {

        if (source == null) {
            return null;
        }
        final Training training = new Training();
        training.setId(source.getId());
        training.setName(source.getName());
        training.setDescription(source.getDescription());
        TrainerAccount author = new TrainerAccount();
        author.setId(source.getAuthorId());

        if (source.getCategories() != null && source.getCategories().size() > 0) {
            source.getCategories().forEach(trainingCategoryCommand -> training.getCategories().add(trainingCategoryCommandConverter.convert(trainingCategoryCommand)));
        }
        if (source.getExercises() != null && source.getExercises().size() > 0) {
            source.getExercises().forEach(exerciseCommand -> training.getExercises().add(exerciseCommandConverter.convert(exerciseCommand)));
        }

        return training;
    }
}
