package com.Itstep.FitnessClub.model.dto.response;

import com.Itstep.FitnessClub.model.dto.TrainingDto;
import com.Itstep.FitnessClub.model.dto.ClientDto;

public record BookingResponseDto(
        ClientDto client,
        TrainingDto training
) {
}
