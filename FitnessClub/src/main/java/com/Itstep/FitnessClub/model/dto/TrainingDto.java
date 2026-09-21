package com.Itstep.FitnessClub.model.dto;

import com.Itstep.FitnessClub.data.TrainingType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record TrainingDto(
        TrainingType trainingType,
        @JsonFormat(
                shape = JsonFormat.Shape.STRING,
                pattern = "dd.MM.yyyy HH:mm",
                timezone = "UTC"
        )
        LocalDateTime trainingStart,
        String trainerName,
        Long roomId
) {
}
