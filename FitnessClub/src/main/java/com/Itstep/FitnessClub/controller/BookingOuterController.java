package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.model.dto.request.BookingRequestDto;
import com.Itstep.FitnessClub.model.dto.response.BookingResponseDto;
import com.Itstep.FitnessClub.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Daria Pevets
 * <p>
 * Отправка запросов по записи на занятия.
 */
@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
@Tag(name = "Бронирование")
public class BookingOuterController {

    private final BookingService bookingService;

    @Operation(summary = "Забронировать тренировку")
    @PostMapping
    public BookingResponseDto bookTraining(@Valid @RequestBody BookingRequestDto bookingRequestDto) {
        return bookingService.bookTraining(bookingRequestDto);
    }
}
