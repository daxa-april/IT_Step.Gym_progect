package com.Itstep.FitnessClub.service.impl;

import com.Itstep.FitnessClub.mapper.TrainingMapper;
import com.Itstep.FitnessClub.model.data.TrainingType;
import com.Itstep.FitnessClub.model.dto.TrainingDto;
import com.Itstep.FitnessClub.model.entity.Training;
import com.Itstep.FitnessClub.repository.TrainingRepository;
import com.Itstep.FitnessClub.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * вывод расписания.
 */
@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final TrainingRepository trainingRepository;
    private final TrainingMapper trainingMapper;

    @Override
    public List<TrainingDto> getSchedule() {
        List<Training> trainings = trainingRepository.findAll();
        return trainingCollectionToTrainingDto(trainings);
    }

    @Override
    public List<TrainingDto> getWeekSchedule(LocalDateTime date) {
        return getScheduleByRange(date, date.plusDays(7));
    }

    @Override
    public List<TrainingDto> getScheduleByRange(LocalDateTime start, LocalDateTime end) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }
        LocalDateTime from = start.withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime to = end.plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0); // the end of the day is included
        return trainingCollectionToTrainingDto(trainingRepository.findByTrainingStartBetween(from, to));
    }

    @Override
    public List<TrainingDto> getScheduleByTrainingName(TrainingType trainingType) {
        return trainingCollectionToTrainingDto(trainingRepository.findByTrainingType(trainingType));
    }

    private List<TrainingDto> trainingCollectionToTrainingDto(List<Training> trainings) {
        return trainings.stream()
                .map(trainingMapper::trainingToTrainingDto)
                .toList();
    }
}
