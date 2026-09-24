package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.model.dto.SubscriptionDto;
import com.Itstep.FitnessClub.service.SubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Daria Pevets
 **/
@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
@Tag(name = "Абонементы", description = "манипуляции с абонементами")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Operation(summary = "Остаток абонемента текущего пользователя")
    @GetMapping("/{id}")
    public SubscriptionDto getMySubscription(@PathVariable("id") Long clientId) {
        return subscriptionService.getSubscriptionByClientId(clientId);
    }

    @Operation(summary = "оформить/обновить абонемент")
    @PostMapping
    public SubscriptionDto createSubscription(@RequestParam Long clientId,
                                              @RequestParam int trainingsToPurchase) {
        return subscriptionService.createSubscription(clientId, trainingsToPurchase);
    }
}
