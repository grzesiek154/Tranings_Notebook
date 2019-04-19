package com.grzegorz_malarski.trainings_notebook.repositories;

import com.grzegorz_malarski.trainings_notebook.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
