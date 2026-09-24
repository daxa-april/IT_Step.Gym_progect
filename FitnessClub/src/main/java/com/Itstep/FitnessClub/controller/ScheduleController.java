package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.model.data.TrainingType;
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
 */

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
@Tag(name = "Расписание", description = "вывод и сортировка расписания тренировок")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Operation(summary = "Без фильтров")
    @GetMapping
    public List<TrainingDto> getFullTrainingSchedule() {
        return scheduleService.getSchedule();
    }

    @Operation(summary = "На неделю")
    @GetMapping("/byDate")
    public List<TrainingDto> getWeekSchedule(
            @RequestParam("day") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return scheduleService.getWeekSchedule(date.atStartOfDay());
    }

    @Operation(summary = "По диапазону дат")
    @GetMapping("/byDateRange")
    public List<TrainingDto> getScheduleByDateRange(
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate from,
            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate to) {

        return scheduleService.getScheduleByRange(
                from.atStartOfDay(),
                to.atTime(23, 59, 59, 999999999));
    }

    @Operation(summary = "По виду тренировок")
    @GetMapping("/{trainingName}")
    public List<TrainingDto> getScheduleByTrainingName(@PathVariable TrainingType trainingName) {
        return scheduleService.getScheduleByTrainingName(trainingName);
    }
}
