package com.Itstep.FitnessClub.repository;

import com.Itstep.FitnessClub.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Хранит информацию о клиентах.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByFullName(String name);

    Client findByPhone(String number);
}
