package com.Itstep.FitnessClub.service;

import com.Itstep.FitnessClub.model.dto.request.BookingRequestDto;
import com.Itstep.FitnessClub.model.dto.response.BookingResponseDto;

/**
 * @author Daria Pevets
 **/
public interface BookingService {
    BookingResponseDto bookTraining(BookingRequestDto bookingRequestDto);
}
