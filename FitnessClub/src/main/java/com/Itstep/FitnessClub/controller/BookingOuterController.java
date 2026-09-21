package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.model.dto.request.BookingRequestDto;
import com.Itstep.FitnessClub.model.dto.response.BookingResponseDto;
import com.Itstep.FitnessClub.service.Impl.BookingServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Отправка запросов по записи на занятия.
 */

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
@Tag(name = "Бронирование")
public class BookingOuterController {

    private final BookingServiceImpl bookingService;

    @Operation(summary = "Забронировать тренировку")
    @PostMapping("/book")
    public BookingResponseDto bookTraining(BookingRequestDto bookingRequestDto) {
        return bookingService.bookTraining(bookingRequestDto);
    }
}
