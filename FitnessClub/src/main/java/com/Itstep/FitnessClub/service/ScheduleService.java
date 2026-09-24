package com.Itstep.FitnessClub.service;

import com.Itstep.FitnessClub.model.data.TrainingType;
import com.Itstep.FitnessClub.model.dto.TrainingDto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Daria Pevets
 **/
public interface ScheduleService {
    List<TrainingDto> getSchedule();

    List<TrainingDto> getWeekSchedule(LocalDateTime date);

    List<TrainingDto> getScheduleByRange(LocalDateTime start, LocalDateTime end);

    List<TrainingDto> getScheduleByTrainingName(TrainingType trainingName);
}
