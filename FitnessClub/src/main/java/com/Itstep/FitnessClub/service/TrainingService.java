package com.Itstep.FitnessClub.service;

import com.Itstep.FitnessClub.model.dto.RoomDto;
import com.Itstep.FitnessClub.model.dto.TrainingDto;
import com.Itstep.FitnessClub.model.entity.Room;
import com.Itstep.FitnessClub.model.entity.Training;
import com.Itstep.FitnessClub.exception.ResourceNotFoundException;

/**
 * @author Daria Pevets
 **/
public interface TrainingService {
    Training findTrainingById(Long trainingId) throws ResourceNotFoundException;

    TrainingDto createTraining(TrainingDto trainingDto);

    Training changeSchedule(Long trainingId, TrainingDto changes);

    void deleteTraining(Long trainingId);

    Room createRoom(RoomDto newRoom);
}
