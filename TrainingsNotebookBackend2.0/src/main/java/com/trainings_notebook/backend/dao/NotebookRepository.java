package com.trainings_notebook.backend.dao;


import com.trainings_notebook.backend.model.Notebook;
import com.trainings_notebook.backend.model.Training;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotebookRepository extends CrudRepository<Notebook, Long> {

    Optional<Notebook> findByName(String name);
    //@Query(value = "select name from notebooks where user_id = :userId", nativeQuery = true)
    //Optional<List<String>> getAllUserNotebooks(@Param("userId")Long userId);
    //Optional<List<Notebook>> getAllUserNotebooks(Long id);
    Optional<List<String>> findAllByUserId(Long userId);
}
