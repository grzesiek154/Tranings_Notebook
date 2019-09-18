package com.grzegorz_malarski.trainings_notebook.converters.entity_to_command;

import com.grzegorz_malarski.trainings_notebook.commands.PostCommand;
import com.grzegorz_malarski.trainings_notebook.model.Post;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class PostToCommand implements Converter<Post, PostCommand> {

    private final CommentToCommand commentToCommandConverter;

    public PostToCommand(CommentToCommand commentToCommandConverter) {
        this.commentToCommandConverter = commentToCommandConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public PostCommand convert(Post source) {

        if(source == null) {
            return null;
        }

        PostCommand postCommand = new PostCommand();
        postCommand.setId(source.getId());
        postCommand.setAuthorId(source.getAuthor().getId());
        postCommand.setContent(source.getContent());
        postCommand.setTitle(source.getTitle());
        if(source.getComments() != null && source.getComments().size() > 0) {
            source.getComments().forEach(comment -> postCommand.getComments().add(commentToCommandConverter.convert(comment)));
        }

        return postCommand;
    }
}
