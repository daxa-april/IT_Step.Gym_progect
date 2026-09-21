package com.Itstep.FitnessClub.model.dto;

import com.Itstep.FitnessClub.data.TrainingType;

/**
 * @author Daria Pevets
 **/
public record RoomDto(
        TrainingType trainingType,
        int capacity
) {
}
