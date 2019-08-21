package com.grzegorz_malarski.trainings_notebook.converters.command_to_entity;

import com.grzegorz_malarski.trainings_notebook.commands.NotebookCommand;
import com.grzegorz_malarski.trainings_notebook.model.Notebook;
import com.grzegorz_malarski.trainings_notebook.model.UserAccount;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotebookCommandToEntity implements Converter<NotebookCommand, Notebook> {

    private final TrainingComandToEntity trainingComandConverter;

    public NotebookCommandToEntity(TrainingComandToEntity trainingComandConverter) {
        this.trainingComandConverter = trainingComandConverter;
    }

    @Override
    public Notebook convert(NotebookCommand source) {

        if (source == null) {
            return null;
        }
        final Notebook notebook = new Notebook();
        notebook.setId(source.getId());
        notebook.setName(source.getName());
        notebook.setNote(source.getNote());
        UserAccount user = new UserAccount();
        user.setId(source.getUserId());
        user.addNotebook(notebook);

        if (source.getTrainings() != null && source.getTrainings().size() > 0) {
            source.getTrainings().forEach(trainingCommand -> notebook.getTrainings().add(trainingComandConverter.convert(trainingCommand)));
        }

        return notebook;
    }
}
