package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.model.dto.SubscriptionDto;
import com.Itstep.FitnessClub.service.SubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Daria Pevets
 **/
@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
@Tag(name = "Абонементы", description = "манипуляции с абонементами")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Operation(summary = "Остаток абонемента текущего пользователя")
    @GetMapping("/api/mySubscription")
    public SubscriptionDto getMySubscription(Long clientId) {
        return subscriptionService.getSubscriptionByClientId(clientId);
    }

    @Operation(summary = "оформить/обновить абонемент")
    @PostMapping
    public SubscriptionDto createSubscription(Long clientId, int trainingsToPurchase) {
        return subscriptionService.createSubscription(clientId, trainingsToPurchase);
    }
}
