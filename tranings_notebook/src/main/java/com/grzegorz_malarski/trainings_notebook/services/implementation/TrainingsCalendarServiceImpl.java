package com.grzegorz_malarski.trainings_notebook.services.implementation;

import com.grzegorz_malarski.trainings_notebook.exceptions.NotFoundException;
import com.grzegorz_malarski.trainings_notebook.model.TrainingsCalendar;
import com.grzegorz_malarski.trainings_notebook.repositories.TrainingsCalendarRepository;
import com.grzegorz_malarski.trainings_notebook.services.TrainingsCalendarService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TrainingsCalendarServiceImpl implements TrainingsCalendarService {


    private final TrainingsCalendarRepository trainingsCalendarRepository;

    public TrainingsCalendarServiceImpl(TrainingsCalendarRepository trainingsCalendarRepository) {
        this.trainingsCalendarRepository = trainingsCalendarRepository;
    }


    @Override
    public Set<TrainingsCalendar> findAll() {
        Set<TrainingsCalendar> trainingsCalendars = new HashSet<>();
        trainingsCalendarRepository.findAll().forEach(trainingsCalendars::add);

        return trainingsCalendars;
    }

    @Override
    public TrainingsCalendar findById(Long aLong) {
        Optional<TrainingsCalendar> trainingsCalendarOptional = trainingsCalendarRepository.findById(aLong);

        if(!trainingsCalendarOptional.isPresent()) {
            throw new NotFoundException("User account with id: " + aLong + " not found");
        }

        return trainingsCalendarOptional.get();
    }

    @Override
    public TrainingsCalendar save(TrainingsCalendar object) {
        return trainingsCalendarRepository.save(object);
    }

    @Override
    public void delete(TrainingsCalendar object) {
        trainingsCalendarRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        trainingsCalendarRepository.deleteById(aLong);
    }
}
