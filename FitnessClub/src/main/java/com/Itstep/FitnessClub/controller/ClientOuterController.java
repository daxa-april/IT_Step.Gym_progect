package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.model.dto.ClientDto;
import com.Itstep.FitnessClub.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Daria Pevets
 * <p>
 * для пользователей (регистрация + редактирование профиля)
 **/
@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@Tag(name = "Личный кабинет", description = "Внешний слой для клиентов")
public class ClientOuterController {

    private final ClientService clientService;

    @Operation(summary = "Добавить пользователя")
    @PostMapping
    public ClientDto createClient(@Valid @RequestBody ClientDto client) {
        return clientService.createNewClient(client);
    }

    @Operation(summary = "Изменить пользователя")
    @PatchMapping
    public ClientDto updateClient(@RequestParam Long clientId, @Valid @RequestBody ClientDto client) {
        return clientService.changeClient(clientId, client);
    }

    @Operation(summary = "Удалить пользователя")
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Long clientId) {
        clientService.deleteClient(clientId);
    }

    @Operation(summary = "Показать информацию о пользователе")
    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable("id") Long clientId) {
        return clientService.getClientById(clientId);
    }
}
