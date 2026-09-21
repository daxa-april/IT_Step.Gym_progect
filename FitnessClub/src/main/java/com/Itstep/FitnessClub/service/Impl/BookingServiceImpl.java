package com.Itstep.FitnessClub.service.Impl;

import com.Itstep.FitnessClub.model.dto.request.BookingRequestDto;
import com.Itstep.FitnessClub.model.dto.response.BookingResponseDto;
import com.Itstep.FitnessClub.model.entity.Booking;
import com.Itstep.FitnessClub.model.entity.Client;
import com.Itstep.FitnessClub.model.entity.Training;
import com.Itstep.FitnessClub.exception.NoPlaceAvailableException;
import com.Itstep.FitnessClub.exception.ResourceNotFoundException;
import com.Itstep.FitnessClub.exception.SubscriptionExpiredException;
import com.Itstep.FitnessClub.mapper.BookingMapperManual;
import com.Itstep.FitnessClub.repository.BookingRepository;
import com.Itstep.FitnessClub.repository.ClientRepository;
import com.Itstep.FitnessClub.repository.RoomRepository;
import com.Itstep.FitnessClub.service.BookingService;
import com.Itstep.FitnessClub.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Запись на тренировку + проверки: действует ли абонемент, есть ли доступные места в залах.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final TrainingService trainingService;
    private final ClientRepository clientRepository;
    private final BookingMapperManual bookingMapper;
    private final RoomRepository roomRepository;

    @Override
    public BookingResponseDto bookTraining(BookingRequestDto bookingRequestDto) {
        Client client = clientRepository.findById(bookingRequestDto.clientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

        Training training = trainingService.findTrainingById(bookingRequestDto.workoutId());

        if (client.getTrainingsLeft() == null || !client.isActive()) {
            throw new SubscriptionExpiredException("Subscription not found or has already expired");
        }

        if (bookingRepository.existsByClientAndTraining(client, training)) {
            throw new NoPlaceAvailableException("Training has already been booked");
        }

        int bookedCount = training.getBookedCount();

        if (bookedCount >= roomRepository.findById(training.getRoomId()).get().getCapacity()) {
            throw new NoPlaceAvailableException("No places available for training");
        }

        Booking booking = new Booking(null, client, training, LocalDateTime.now());
        bookingRepository.save(booking);
        client.setTrainingsLeft(client.getTrainingsLeft() - 1);
        training.setBookedCount(bookedCount + 1);
        return bookingMapper.bookingToBookingResponseDto(booking);
    }
}
