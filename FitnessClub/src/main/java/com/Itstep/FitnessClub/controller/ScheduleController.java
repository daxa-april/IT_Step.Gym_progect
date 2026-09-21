package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.data.TrainingType;
import com.Itstep.FitnessClub.model.dto.TrainingDto;
import com.Itstep.FitnessClub.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/*
 * Отправка запросов на вывод расписания.
 *
 */

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
@Tag(name = "Внутренний сервис расписания", description = "вывод и сортировка расписания")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Operation(summary = "Без фильтров")
    @GetMapping("/api/schedule")
    public List<TrainingDto> getFullTrainingSchedule() {
        return scheduleService.getSchedule();
    }

    @Operation(summary = "По дате")
    @GetMapping("/schedule/byDate")
    public List<TrainingDto> getScheduleByDate(
            @RequestParam("day") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return scheduleService.getScheduleByDate(date.atStartOfDay());
    }

    @Operation(summary = "По диапазону дат")
    @GetMapping("/schedule/byDateRange")
    public List<TrainingDto> getScheduleByDateRange(
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate from,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate to) {

        return scheduleService.getScheduleByRange(
                from.atStartOfDay(),
                to.atTime(23, 59, 59, 999999999));
    }

    @Operation(summary = "По виду тренировок")
    @GetMapping("/trainingName/{trainingName}")
    public List<TrainingDto> getScheduleByTrainingName(@PathVariable TrainingType trainingName) {
        return scheduleService.getScheduleByTrainingName(trainingName);
    }
}
