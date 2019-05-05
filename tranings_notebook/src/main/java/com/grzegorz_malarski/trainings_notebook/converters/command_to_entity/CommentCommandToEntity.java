package com.grzegorz_malarski.trainings_notebook.converters.command_to_entity;

import com.grzegorz_malarski.trainings_notebook.commands.CommentCommand;
import com.grzegorz_malarski.trainings_notebook.model.BaseAppAccount;
import com.grzegorz_malarski.trainings_notebook.model.Comment;
import com.grzegorz_malarski.trainings_notebook.model.Post;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CommentCommandToEntity implements Converter<CommentCommand, Comment> {

    @Synchronized
    @Nullable
    @Override
    public Comment convert(CommentCommand source) {

        if (source == null) {
            return null;
        }

        final Comment comment = new Comment();

        comment.setId(source.getId());
        if (source.getAuthorId() != null && source.getAuthorId() != null) {
            BaseAppAccount author = new BaseAppAccount();
            author.setId(source.getAuthorId());
            Post post = new Post();
            post.setId(source.getPostId());
            comment.setAuthor(author);
            comment.setPost(post);
            comment.setContent(source.getContent());
            post.addComment(comment);
        }

        return comment;
    }
}
