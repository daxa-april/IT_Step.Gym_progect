package com.Itstep.FitnessClub.service;

import com.Itstep.FitnessClub.exception.ResourceNotFoundException;
import com.Itstep.FitnessClub.model.dto.RoomDto;
import com.Itstep.FitnessClub.model.dto.TrainingDto;

/**
 * @author Daria Pevets
 **/
public interface TrainingService {
    TrainingDto findTrainingById(Long trainingId) throws ResourceNotFoundException;

    TrainingDto createTraining(TrainingDto trainingDto);

    TrainingDto changeSchedule(Long trainingId, TrainingDto changes);

    void deleteTraining(Long trainingId);

    RoomDto createRoom(RoomDto newRoom);
}
