package com.Itstep.FitnessClub.service;

import com.Itstep.FitnessClub.model.dto.ClientDto;
import com.Itstep.FitnessClub.model.dto.ClientInnerDto;

/**
 * @author Daria Pevets
 **/
public interface ClientService {
    ClientDto createNewClient(ClientDto client);

    void deleteClient(Long clientId);

    ClientDto getClientById(Long clientId);

    ClientDto changeClient(Long clientId, ClientDto client);

    ClientInnerDto findByFullName(String fullName);

    ClientInnerDto findByPhone(String number);
}
