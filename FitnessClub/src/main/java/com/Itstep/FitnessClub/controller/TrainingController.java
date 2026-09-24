package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.model.dto.RoomDto;
import com.Itstep.FitnessClub.model.dto.TrainingDto;
import com.Itstep.FitnessClub.service.TrainingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Отправка запросов на изменение расписания.
 */

@RestController
@RequestMapping("/trainings")
@RequiredArgsConstructor
@Tag(name = "Внутренний сервис тренировок", description = "создание и изменение тренировок и залов")
public class TrainingController {

    private final TrainingService trainingService;

    @Operation(summary = "Создание тренировки")
    @PostMapping
    public TrainingDto createTraining(@RequestBody TrainingDto training) {
        return trainingService.createTraining(training);
    }

    @Operation(summary = "Изменение тренировки")
    @PatchMapping("/{id}")
    public TrainingDto changeTraining(
            @PathVariable("id") Long trainingId,
            @Valid @RequestBody TrainingDto trainingToChange) {
        return trainingService.changeSchedule(trainingId, trainingToChange);
    }

    @Operation(summary = "Удаление тренировки")
    @DeleteMapping("/{id}")
    public void deleteTraining(@PathVariable("id") Long trainingId) {
        trainingService.deleteTraining(trainingId);
    }

    @Operation(summary = "Создание спортивного зала")
    @PostMapping("/createRoom")
    public RoomDto createRoom(@Valid @RequestBody RoomDto newRoom) {
        return trainingService.createRoom(newRoom);
    }
}
