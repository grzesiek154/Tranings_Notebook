package com.grzegorz_malarski.trainings_notebook.converters.entity_to_command;

import com.grzegorz_malarski.trainings_notebook.commands.NotebookCommand;
import com.grzegorz_malarski.trainings_notebook.model.Notebook;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotebookToCommand implements Converter<Notebook, NotebookCommand> {

    private final TrainingToCommand trainingToCommandConverter;

    public NotebookToCommand(TrainingToCommand trainingToCammandConverter) {
        this.trainingToCommandConverter = trainingToCammandConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public NotebookCommand convert(Notebook source) {

        if(source == null) {
            return null;
        }
        NotebookCommand notebookCommand = new NotebookCommand();
        notebookCommand.setId(source.getId());
        notebookCommand.setName(source.getName());
        notebookCommand.setNote(source.getNote());
        notebookCommand.setUserId(source.getUser().getId());

        if(source.getTrainings() !=null && source.getTrainings().size() > 0) {
            source.getTrainings().forEach(training -> notebookCommand.getTrainings().add(trainingToCommandConverter.convert(training)));
        }

        return notebookCommand;
    }
}
