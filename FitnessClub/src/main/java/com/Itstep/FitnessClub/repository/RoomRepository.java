package com.Itstep.FitnessClub.repository;

import com.Itstep.FitnessClub.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Хранит информацию о залах: вместительность + свободные места.
 */
@Repository

public interface RoomRepository extends JpaRepository<Room, Long> {

    Room findById(long id);

}
