package com.grzegorz_malarski.trainings_notebook.services;

import com.grzegorz_malarski.trainings_notebook.model.Comment;
import com.grzegorz_malarski.trainings_notebook.model.Post;

public interface PostService extends CrudService<Post, Long> {

    Post findByTitle(String title);
    Comment addCommentToPost(Comment comment);

}
