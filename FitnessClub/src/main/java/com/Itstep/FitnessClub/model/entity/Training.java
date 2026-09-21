package com.Itstep.FitnessClub.model.entity;

import com.Itstep.FitnessClub.data.TrainingType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "trainings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Training {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingId;

    @Enumerated(EnumType.STRING)
    private TrainingType trainingType;

    private LocalDateTime trainingStart;
    private String trainerName;
    private Long roomId;

    @Column(name = "booked_count")
    private int bookedCount;
}
