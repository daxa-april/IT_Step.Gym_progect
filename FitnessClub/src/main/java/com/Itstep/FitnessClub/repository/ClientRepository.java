package com.Itstep.FitnessClub.repository;

import com.Itstep.FitnessClub.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Хранит информацию о клиентах.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByFullName(String name);

    Client findByPhone(String number);
}
