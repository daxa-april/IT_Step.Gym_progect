package com.Itstep.FitnessClub.service.Impl;

import com.Itstep.FitnessClub.model.dto.RoomDto;
import com.Itstep.FitnessClub.model.dto.TrainingDto;
import com.Itstep.FitnessClub.model.entity.Room;
import com.Itstep.FitnessClub.model.entity.Training;
import com.Itstep.FitnessClub.exception.ResourceNotFoundException;
import com.Itstep.FitnessClub.mapper.TrainingMapper;
import com.Itstep.FitnessClub.repository.RoomRepository;
import com.Itstep.FitnessClub.repository.TrainingRepositoryInterface;
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

    private final TrainingRepositoryInterface trainingRepository;
    private final RoomRepository roomRepository;
    private final TrainingMapper trainingMapper;

    @Transactional(readOnly = true)
    @Override
    public Training findTrainingById(Long trainingId) throws ResourceNotFoundException {
        return trainingRepository.findById(trainingId)
                .orElseThrow(() -> new ResourceNotFoundException("Training not found"));
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
    public Training changeSchedule(Long trainingId, TrainingDto changes) {
        Training trainingFound = findTrainingById(trainingId);
        trainingFound.setTrainingId(trainingId);
        trainingFound.setTrainingStart(changes.trainingStart());
        trainingFound.setTrainerName(changes.trainerName());
        trainingFound.setRoomId(changes.roomId());
        trainingFound.setTrainingType(changes.trainingType());
        trainingFound.setBookedCount(trainingFound.getBookedCount());
        return trainingFound;
    }

    @Transactional
    @Override
    public void deleteTraining(Long trainingId) {
        Training training = findTrainingById(trainingId);
        trainingRepository.delete(training);
    }

    @Transactional
    @Override
    public Room createRoom(RoomDto newRoom) {
        return roomRepository.save(trainingMapper.roomDtoToRoom(newRoom));
    }
}
