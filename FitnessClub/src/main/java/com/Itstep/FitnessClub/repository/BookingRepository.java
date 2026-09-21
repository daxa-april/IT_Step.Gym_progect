package com.Itstep.FitnessClub.repository;

import com.Itstep.FitnessClub.model.entity.Booking;
import com.Itstep.FitnessClub.model.entity.Client;
import com.Itstep.FitnessClub.model.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Хранит записи на тренировки.
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    boolean existsByClientAndTraining(Client client, Training training);
}
