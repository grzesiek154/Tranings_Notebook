package com.grzegorz_malarski.trainings_notebook.converters.command_to_entity;

import com.grzegorz_malarski.trainings_notebook.commands.PostCommand;
import com.grzegorz_malarski.trainings_notebook.model.Post;
import com.grzegorz_malarski.trainings_notebook.model.TrainerAccount;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PostCommandToEntity implements Converter<PostCommand, Post> {

    private final CommentCommandToEntity commentCommandConverter;

    public PostCommandToEntity(CommentCommandToEntity commentCommandConverter) {
        this.commentCommandConverter = commentCommandConverter;
    }

    @Override
    public Post convert(PostCommand source) {

        if (source == null) {
            return null;
        }

        Post post = new Post();
        post.setId(source.getId());
        TrainerAccount trainer = new TrainerAccount();
        trainer.setId(source.getAuthorId());
        post.setAuthor(trainer);
        post.setContent(source.getContent());
        post.setTitle(source.getTitle());
        post.setContent(source.getContent());
        post.setCreateDate(source.getCreateDate());

        if (source.getComments() != null && source.getComments().size() > 0) {
            source.getComments().forEach(commentCommand -> post.getComments().add(commentCommandConverter.convert(commentCommand)));
        }
        return post;
    }
}
