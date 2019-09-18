package com.grzegorz_malarski.trainings_notebook.converters.entity_to_command;

import com.grzegorz_malarski.trainings_notebook.commands.TrainerAccountCommand;
import com.grzegorz_malarski.trainings_notebook.model.TrainerAccount;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TrainerAccountToCommand implements Converter<TrainerAccount, TrainerAccountCommand> {


    private final ExerciseToCommand exerciseToCommandConverter;
    private final TrainingToCommand trainingToCommandConverter;
    private final PostToCommand postToCommandConverter;
    private final CommentToCommand commentToCommandConverter;

    public TrainerAccountToCommand(ExerciseToCommand exerciseToCommandConverter, TrainingToCommand trainingToCommandConverter, PostToCommand postToCommandConverter, CommentToCommand commentToCommandConverter) {
        this.exerciseToCommandConverter = exerciseToCommandConverter;

        this.trainingToCommandConverter = trainingToCommandConverter;
        this.postToCommandConverter = postToCommandConverter;
        this.commentToCommandConverter = commentToCommandConverter;
    }

    @Override
    public TrainerAccountCommand convert(TrainerAccount source) {

        if(source == null) {
            return null;
        }

        TrainerAccountCommand trainerAccountCommand = new TrainerAccountCommand();
        trainerAccountCommand.setId(source.getId());
        trainerAccountCommand.setSpecialization(source.getSpecialization());
        trainerAccountCommand.setEmail(source.getEmail());
        trainerAccountCommand.setName(source.getName());
        trainerAccountCommand.setSurname(source.getSurname());
        trainerAccountCommand.setJoinDate(source.getJoinDate());
        trainerAccountCommand.setPassword(source.getPassword());
        trainerAccountCommand.setRole(source.getRole());
        if(source.getExercisesAdded() != null && source.getExercisesAdded().size() > 0) {
            source.getExercisesAdded().forEach(exercise -> trainerAccountCommand.getExercises().add(exerciseToCommandConverter.convert(exercise)));
        }
        if(source.getTrainingsAdded() != null && source.getTrainingsAdded().size() > 0) {
            source.getTrainingsAdded().forEach(training -> trainerAccountCommand.getTrainings().add(trainingToCommandConverter.convert(training)));
        }
        if(source.getPosts() != null && source.getPosts().size() > 0) {
            source.getPosts().forEach(post -> trainerAccountCommand.getPosts().add(postToCommandConverter.convert(post)));
        }
        if(source.getComments() != null && source.getComments().size() >0){
            source.getComments().forEach(comment -> trainerAccountCommand.getComments().add(commentToCommandConverter.convert(comment)));
        }

        return trainerAccountCommand;
    }
}
