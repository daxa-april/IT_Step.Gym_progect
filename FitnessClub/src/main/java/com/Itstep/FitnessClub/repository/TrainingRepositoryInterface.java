package com.Itstep.FitnessClub.repository;

import com.Itstep.FitnessClub.data.TrainingType;
import com.Itstep.FitnessClub.model.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Daria Pevets
 **/
public interface TrainingRepositoryInterface extends JpaRepository<Training, Long> {

    List<Training> findByTrainingStartBetween(LocalDateTime trainingStart, LocalDateTime trainingEnd);

    List<Training> findByTrainingType(TrainingType trainingName);
}
