//package com.grzegorz_malarski.trainings_notebook.converters.entity_to_command;
//
//import com.grzegorz_malarski.trainings_notebook.commands.TrainingsCalendarCommand;
//import com.grzegorz_malarski.trainings_notebook.model.TrainingsCalendar;
//import lombok.Synchronized;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.lang.Nullable;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TrainingsCalendarToCommand implements Converter<TrainingsCalendar, TrainingsCalendarCommand> {
//
//    private final TrainingToCommand trainingToCommandConverter;
//
//    public TrainingsCalendarToCommand(TrainingToCommand trainingToCommandConverter) {
//        this.trainingToCommandConverter = trainingToCommandConverter;
//    }
//
//    @Synchronized
//    @Nullable
//    @Override
//    public TrainingsCalendarCommand convert(TrainingsCalendar source) {
//
//        if(source == null) {
//            return null;
//        }
//
//        TrainingsCalendarCommand trainingsCalendarCommand = new TrainingsCalendarCommand();
//        trainingsCalendarCommand.setId(source.getId());
//        trainingsCalendarCommand.setMonth(source.getMonth());
//        trainingsCalendarCommand.setUserId(source.getUser().getId());
//        trainingsCalendarCommand.setYear(source.getYear());
//
//        if (source.getTrainings() != null && source.getTrainings().size() > 0) {
//            source.getTrainings().forEach(training -> trainingsCalendarCommand.getTrainings().add(trainingToCommandConverter.convert(training)));
//        }
//        return trainingsCalendarCommand;
//    }
//}
