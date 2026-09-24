package com.Itstep.FitnessClub.model.entity;

import com.Itstep.FitnessClub.model.data.TrainingType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(150)")
    private TrainingType trainingType;
    private int capacity;
}
