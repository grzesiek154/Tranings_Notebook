package com.trainings_notebook.backend.dao;

import com.grzegorz_malarski.trainings_notebook.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    Optional<Post> findByTitle(String title);
   // Post addCommentToPost(Comment comment);
}
