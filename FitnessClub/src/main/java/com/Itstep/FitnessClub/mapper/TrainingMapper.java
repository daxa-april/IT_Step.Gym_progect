package com.Itstep.FitnessClub.mapper;

import com.Itstep.FitnessClub.model.dto.RoomDto;
import com.Itstep.FitnessClub.model.dto.TrainingDto;
import com.Itstep.FitnessClub.model.entity.Room;
import com.Itstep.FitnessClub.model.entity.Training;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Daria Pevets
 **/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TrainingMapper {

    TrainingDto trainingToTrainingDto(Training training);

    Training trainingDtoToTraining(TrainingDto trainingDto);

    Room roomDtoToRoom(RoomDto roomDto);

    RoomDto roomToRoomDto(Room room);

}
