package com.Itstep.FitnessClub.mapper;

import com.Itstep.FitnessClub.model.dto.response.BookingResponseDto;
import com.Itstep.FitnessClub.model.entity.Booking;
import com.Itstep.FitnessClub.model.entity.Client;
import com.Itstep.FitnessClub.model.entity.Training;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Daria Pevets
 **/
@Component
@RequiredArgsConstructor
public class BookingMapperManual {

    private final ClientMapper clientMapper;
    private final TrainingMapper trainingMapper;

    public BookingResponseDto bookingToBookingResponseDto(Booking booking) {
        if (booking == null) {
            return null;
        }
        Client client = booking.getClient();
        Training training = booking.getTraining();
        return new BookingResponseDto(clientMapper.clientToClientDto(client), trainingMapper.trainingToTrainingDto(training));
    }
}

