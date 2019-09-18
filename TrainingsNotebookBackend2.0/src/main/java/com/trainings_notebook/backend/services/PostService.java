package com.trainings_notebook.backend.services;


import com.trainings_notebook.backend.model.Post;

public interface PostService extends CrudService<Post, Long> {

    Post findByTitle(String title);
//    Comment addCommentToPost(Comment comment);

}
