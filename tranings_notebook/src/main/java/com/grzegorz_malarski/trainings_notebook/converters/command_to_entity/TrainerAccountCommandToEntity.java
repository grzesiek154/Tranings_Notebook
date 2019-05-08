package com.grzegorz_malarski.trainings_notebook.converters.command_to_entity;

import com.grzegorz_malarski.trainings_notebook.commands.TrainerAccountCommand;
import com.grzegorz_malarski.trainings_notebook.model.TrainerAccount;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TrainerAccountCommandToEntity implements Converter<TrainerAccountCommand, TrainerAccount> {

    private final ExerciseCommandToEntity exerciseCommandConverter;
    private final TrainingComandToEntity trainingComandConverter;
    private final PostCommandToEntity postCommandConverter;
    private final CommentCommandToEntity commentCommandConverter;

    public TrainerAccountCommandToEntity(ExerciseCommandToEntity exerciseCommandConverter, TrainingComandToEntity trainingComandConverter, PostCommandToEntity postCommandConverter, CommentCommandToEntity commentCommandConverter) {
        this.exerciseCommandConverter = exerciseCommandConverter;
        this.trainingComandConverter = trainingComandConverter;
        this.postCommandConverter = postCommandConverter;
        this.commentCommandConverter = commentCommandConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public TrainerAccount convert(TrainerAccountCommand source) {

        if (source == null) {
            return null;
        }
        TrainerAccount trainer = new TrainerAccount();
        trainer.setId(source.getId());
        trainer.setName(source.getName());
        trainer.setSurname(source.getSurname());
        trainer.setJoinDate(source.getJoinDate());
        trainer.setEmail(source.getEmail());
        trainer.setPassword(source.getPassword());
        trainer.setRole(source.getRole());
        trainer.setSpecialization(source.getSpecialization());

        if (source.getExercises() != null && source.getExercises().size() > 0) {
            source.getExercises().forEach(exerciseCommand -> trainer.getExercisesAdded().add(exerciseCommandConverter.convert(exerciseCommand)));
        }

        if (source.getTrainings() != null && source.getExercises().size() > 0) {
            source.getTrainings().forEach(trainingCommand -> trainer.getTrainingsAdded().add(trainingComandConverter.convert(trainingCommand)));
        }

        if (source.getPosts() != null && source.getPosts().size() > 0) {
            source.getPosts().forEach(postCommand -> trainer.getPosts().add(postCommandConverter.convert(postCommand)));
        }
        if (source.getComments() != null && source.getComments().size() > 0) {
            source.getComments().forEach(commentCommand -> trainer.getComments().add(commentCommandConverter.convert(commentCommand)));
        }
        return trainer;
    }
}
