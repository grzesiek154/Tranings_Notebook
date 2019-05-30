package com.grzegorz_malarski.trainings_notebook.converters.command_to_entity;

import com.grzegorz_malarski.trainings_notebook.commands.UserAccountCommand;
import com.grzegorz_malarski.trainings_notebook.model.UserAccount;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserAccountCommandToEntity implements Converter<UserAccountCommand, UserAccount> {

    private final NotebookCommandToEntity notebookCommandConverter;
    private final CommentCommandToEntity commentCommandConverter;

    public UserAccountCommandToEntity(NotebookCommandToEntity notebookCommandConverter,  CommentCommandToEntity commentCommandConverter) {
        this.notebookCommandConverter = notebookCommandConverter;
        this.commentCommandConverter = commentCommandConverter;
    }

    @Override
    public UserAccount convert(UserAccountCommand source) {
        if (source == null) {
            return null;
        }

        UserAccount user = new UserAccount();
        user.setId(source.getId());
        user.setName(source.getName());
        user.setSurname(source.getSurname());
        user.setJoinDate(source.getJoinDate());
        user.setEmail(source.getEmail());
        user.setPassword(source.getPassword());
        user.setRole(source.getRole());
        user.setNickname(source.getNickname());
        user.setBirthDate(source.getBirthDate());
        user.setWeight(source.getWeight());
        user.setHeight(source.getHeight());

        if (source.getNotebooks() != null && source.getNotebooks().size() > 0) {
            source.getNotebooks().forEach(notebookCommand -> user.getNotebooks().add(notebookCommandConverter.convert(notebookCommand)));
        }


        if (source.getComments() != null && source.getComments().size() > 0) {
            source.getComments().forEach(commentCommand -> user.getComments().add(commentCommandConverter.convert(commentCommand)));
        }

        return user;
    }
}
