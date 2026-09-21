package com.Itstep.FitnessClub.service.Impl;

import com.Itstep.FitnessClub.model.dto.ClientDto;
import com.Itstep.FitnessClub.model.dto.ClientInnerDto;
import com.Itstep.FitnessClub.model.entity.Client;
import com.Itstep.FitnessClub.exception.ResourceNotFoundException;
import com.Itstep.FitnessClub.mapper.ClientMapper;
import com.Itstep.FitnessClub.repository.ClientRepository;
import com.Itstep.FitnessClub.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Daria Pevets
 **/
@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Transactional
    @Override
    public ClientDto createNewClient(ClientDto client) {
        Client clientToSave = clientRepository.save(clientMapper.clientDtoToClient(client));
        return clientMapper.clientToClientDto(clientToSave);
    }

    @Transactional
    @Override
    public void deleteClient(Long clientId) {
        if (clientRepository.existsById(clientId)) {
            clientRepository.deleteById(clientId);
        } else {
            throw new ResourceNotFoundException("Client with id " + clientId + " not found");
        }
    }

    @Override
    public ClientDto getClientById(Long clientId) {
        if (clientRepository.findById(clientId).isPresent()) {
            return clientMapper.clientToClientDto(clientRepository.findById(clientId).get());
        } else {
            throw new ResourceNotFoundException("Client with id " + clientId + " not found");
        }
    }

    @Transactional
    @Override
    public ClientDto changeClient(Long clientId, ClientDto client) {
        if (clientRepository.findById(clientId).isPresent()) {
            Client clientToChange = clientRepository.findById(clientId).get();
            clientToChange.setId(clientId);
            clientToChange.setFullName(client.fullName());
            clientToChange.setEmail(client.email());
            clientToChange.setPhone(client.phone());
            clientRepository.save(clientToChange);
            return clientMapper.clientToClientDto(clientToChange);
        } else {
            throw new ResourceNotFoundException("Client not found");
        }
    }

    @Override
    public ClientInnerDto findByFullName(String fullName) {
        return clientMapper.clientToClientInnerDto(clientRepository.findByFullName(fullName));
    }

    @Override
    public ClientInnerDto findByPhone(String number) {
        return clientMapper.clientToClientInnerDto(clientRepository.findByPhone(number));
    }
}
