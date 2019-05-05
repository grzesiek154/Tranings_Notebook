package com.grzegorz_malarski.trainings_notebook.converters.command_to_entity;

import com.grzegorz_malarski.trainings_notebook.commands.BaseAppAccountCommand;
import com.grzegorz_malarski.trainings_notebook.model.BaseAppAccount;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class BaseAppAccountCommandToEntity implements Converter<BaseAppAccountCommand, BaseAppAccount> {

    private final CommentCommandToEntity commentConverter;

    public BaseAppAccountCommandToEntity(CommentCommandToEntity commentConverter) {
        this.commentConverter = commentConverter;
    }

    @Override
    public BaseAppAccount convert(BaseAppAccountCommand source) {

        if (source == null) {
            return null;
        }
        final BaseAppAccount account = new BaseAppAccount();
        account.setId(source.getId());
        account.setName(source.getName());
        account.setSurname(source.getSurname());
        account.setPassword(source.getPassword());
        account.setJoinDate(source.getJoinDate());
        account.setEmail(source.getEmail());
        account.setRole(source.getRole());

        if (source.getComments() != null && source.getComments().size() > 0) {
            source.getComments().forEach(commentCommand -> account.getComments().add(commentConverter.convert(commentCommand)));
            // dodajemy do listy komentarzy, komentarze z command klasy jednoczesnie konwertujac kazdy komentarz z command obiektu na entity
        }
        return account;
    }
}
