package com.grzegorz_malarski.trainings_notebook.converters.entity_to_command;

import com.grzegorz_malarski.trainings_notebook.commands.CommentCommand;
import com.grzegorz_malarski.trainings_notebook.model.Comment;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class CommentToCommand implements Converter<Comment, CommentCommand> {

    @Synchronized
    @Nullable
    @Override
    public CommentCommand convert(Comment source) {

        if(source == null) {
            return null;
        }

        CommentCommand commentCommand = new CommentCommand();
        commentCommand.setId(source.getId());
        if(source.getAuthor() != null) {
            commentCommand.setAuthorId(source.getAuthor().getId());
        }
        if(source.getPost() != null) {
            commentCommand.setPostId(source.getPost().getId());
        }
        commentCommand.setContent(source.getContent());
        commentCommand.setCreateDate(source.getCreateDate());

        return commentCommand;
    }
}
