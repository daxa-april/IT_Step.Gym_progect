package com.Itstep.FitnessClub.service.impl;

import com.Itstep.FitnessClub.exception.ResourceNotFoundException;
import com.Itstep.FitnessClub.mapper.TrainingMapper;
import com.Itstep.FitnessClub.model.dto.RoomDto;
import com.Itstep.FitnessClub.model.dto.TrainingDto;
import com.Itstep.FitnessClub.model.entity.Room;
import com.Itstep.FitnessClub.model.entity.Training;
import com.Itstep.FitnessClub.repository.RoomRepository;
import com.Itstep.FitnessClub.repository.TrainingRepository;
import com.Itstep.FitnessClub.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Внутренний сервис клуба.
 * Добавление, редактирование и удаление тренировок и комнат.
 */

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;
    private final RoomRepository roomRepository;
    private final TrainingMapper trainingMapper;

    @Transactional(readOnly = true)
    @Override
    public TrainingDto findTrainingById(Long trainingId) {
        if (trainingRepository.findById(trainingId).isPresent()) {
            return trainingMapper.trainingToTrainingDto(trainingRepository.findById(trainingId).get());
        } else {
            throw new ResourceNotFoundException("Training with id " + trainingId + " not found");
        }
    }

    @Transactional
    @Override
    public TrainingDto createTraining(TrainingDto trainingDto) {
        Training newTraining = trainingMapper.trainingDtoToTraining(trainingDto);
        trainingRepository.save(newTraining);
        return trainingMapper.trainingToTrainingDto(newTraining);
    }

    @Transactional
    @Override
    public TrainingDto changeSchedule(Long trainingId, TrainingDto changes) {
        Training trainingFound = trainingMapper.trainingDtoToTraining(findTrainingById(trainingId));
        trainingFound.setTrainingId(trainingId);
        trainingFound.setTrainingStart(changes.trainingStart());
        trainingFound.setTrainerName(changes.trainerName());
        trainingFound.setRoomId(changes.roomId());
        trainingFound.setTrainingType(changes.trainingType());
        trainingFound.setBookedCount(trainingFound.getBookedCount());
        return trainingMapper.trainingToTrainingDto(trainingFound);
    }

    @Override
    public void deleteTraining(Long trainingId) {
        if (trainingRepository.existsById(trainingId)) {
            trainingRepository.deleteById(trainingId);
        } else {
            throw new ResourceNotFoundException("Training with id " + trainingId + " not found");
        }
    }

    @Transactional
    @Override
    public RoomDto createRoom(RoomDto newRoom) {
        Room room = trainingMapper.roomDtoToRoom(newRoom);
        roomRepository.save(room);
        return trainingMapper.roomToRoomDto(room);
    }
}
