package com.Itstep.FitnessClub.service.Impl;

import com.Itstep.FitnessClub.data.TrainingType;
import com.Itstep.FitnessClub.model.dto.TrainingDto;
import com.Itstep.FitnessClub.model.entity.Training;
import com.Itstep.FitnessClub.mapper.TrainingMapper;
import com.Itstep.FitnessClub.repository.TrainingRepositoryInterface;
import com.Itstep.FitnessClub.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * вывод расписания.
 */
@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final TrainingRepositoryInterface trainingRepository;
    private final TrainingMapper trainingMapper;

    @Override
    public List<TrainingDto> getSchedule() {
        List<Training> trainings = trainingRepository.findAll();
        return trainings.stream()
                .map(trainingMapper::trainingToTrainingDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingDto> getScheduleByDate(LocalDateTime date) {
        return getScheduleByRange(date, date);
    }

    @Override
    public List<TrainingDto> getScheduleByRange(LocalDateTime start, LocalDateTime end) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }
        LocalDateTime from = start.withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime to = end.plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0); // the end of the day is included
        return trainingRepository.findByTrainingStartBetween(from, to)
                .stream()
                .map(trainingMapper::trainingToTrainingDto)
                .toList();
    }

    @Override
    public List<TrainingDto> getScheduleByTrainingName(TrainingType trainingName) {
        return trainingRepository.findByTrainingType(trainingName).stream()
                .map(trainingMapper::trainingToTrainingDto)
                .collect(Collectors.toList());
    }
}
