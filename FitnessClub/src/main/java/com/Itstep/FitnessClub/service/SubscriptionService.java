package com.Itstep.FitnessClub.service;

import com.Itstep.FitnessClub.model.dto.SubscriptionDto;

/**
 * @author Daria Pevets
 **/
public interface SubscriptionService {
    SubscriptionDto createSubscription(Long clientId, int trainings);

    SubscriptionDto getSubscriptionByClientId(Long ClientId);
}
