package com.trainings_notebook.backend.dao;


import com.trainings_notebook.backend.model.TrainingsCalendar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingsCalendarRepository extends CrudRepository<TrainingsCalendar, Long> {
}
