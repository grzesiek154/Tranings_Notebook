package com.grzegorz_malarski.trainings_notebook.repositories;

import com.grzegorz_malarski.trainings_notebook.model.TrainingsCalendar;
import org.springframework.data.repository.CrudRepository;

public interface TrainingsCalendarRepository extends CrudRepository<TrainingsCalendar, Long> {
}
