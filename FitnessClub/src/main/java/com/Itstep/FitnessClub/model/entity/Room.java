package com.Itstep.FitnessClub.model.entity;

import com.Itstep.FitnessClub.data.TrainingType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table (name = "rooms")
public class Room {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "training_type", columnDefinition = "VARCHAR(150)")
    private TrainingType trainingType;
    private int capacity;
}
