package com.Itstep.FitnessClub.repository;

import com.Itstep.FitnessClub.model.data.TrainingType;
import com.Itstep.FitnessClub.model.entity.Training;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Daria Pevets
 **/
public interface TrainingRepository extends JpaRepository<Training, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Training findWithLockByTrainingId(Long trainingId);

    List<Training> findByTrainingStartBetween(LocalDateTime trainingStart, LocalDateTime trainingEnd);

    List<Training> findByTrainingType(TrainingType trainingName);

}
