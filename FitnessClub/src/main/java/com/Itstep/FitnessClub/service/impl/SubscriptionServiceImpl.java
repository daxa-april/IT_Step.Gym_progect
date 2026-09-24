package com.Itstep.FitnessClub.service.impl;

import com.Itstep.FitnessClub.exception.ResourceNotFoundException;
import com.Itstep.FitnessClub.mapper.SubscriptionMapper;
import com.Itstep.FitnessClub.model.dto.SubscriptionDto;
import com.Itstep.FitnessClub.model.entity.Client;
import com.Itstep.FitnessClub.repository.ClientRepository;
import com.Itstep.FitnessClub.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Daria Pevets
 **/
@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionMapper subscriptionMapper;
    private final ClientRepository clientRepository;


    @Transactional
    @Override
    public SubscriptionDto createSubscription(Long clientId, int trainings) {
        if (clientRepository.existsById(clientId)) {
            Client client = clientRepository.findById(clientId).get();
            client.setTrainingsLeft(trainings);
            clientRepository.save(client);
            return subscriptionMapper.mapClientToSubDto(client);
        } else {
            throw new ResourceNotFoundException("Client not found");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public SubscriptionDto getSubscriptionByClientId(Long clientId) {
        if (clientRepository.existsById(clientId)) {
            return subscriptionMapper.mapClientToSubDto(clientRepository.findById(clientId).get());
        } else {
            throw new ResourceNotFoundException("Client not found");
        }
    }
}
