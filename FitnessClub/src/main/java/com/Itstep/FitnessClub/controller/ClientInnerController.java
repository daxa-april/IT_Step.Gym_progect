package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.model.dto.ClientInnerDto;
import com.Itstep.FitnessClub.model.dto.SubscriptionDto;
import com.Itstep.FitnessClub.service.ClientService;
import com.Itstep.FitnessClub.service.SubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Daria Pevets
 **/
@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@Tag(name = "Кабинет фитнес центра", description = "Внутренний поиск и изменение абонементов")
public class ClientInnerController {

    private final ClientService clientService;
    private final SubscriptionService subscriptionService;

    @Operation(summary = "Изменить абонемент")
    @PatchMapping("/{id}")
    public SubscriptionDto updateClientSubscription(@PathVariable("id") Long clientId, @RequestParam int trainingsLeft) {
        return subscriptionService.createSubscription(clientId, trainingsLeft);
    }

    @Operation(summary = "Поиск абонемента по имени пользователя")
    @GetMapping("/byName")
    public ClientInnerDto findByFullName(@RequestParam String fullName) {
        return clientService.findByFullName(fullName);
    }

    @Operation(summary = "Поиск абонемента по номеру телефона")
    @GetMapping("/byNumber")
    public ClientInnerDto findByPhone(@RequestParam String number) {
        return clientService.findByPhone(number);
    }
}
