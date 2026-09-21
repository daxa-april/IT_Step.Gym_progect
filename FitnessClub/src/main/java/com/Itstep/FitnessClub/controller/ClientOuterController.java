package com.Itstep.FitnessClub.controller;

import com.Itstep.FitnessClub.model.dto.ClientDto;
import com.Itstep.FitnessClub.exception.ResourceNotFoundException;
import com.Itstep.FitnessClub.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Daria Pevets
 * <p>
 * Внешний контроллер для пользователей (регистрация + редактирование профиля)
 **/
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "Личный кабинет", description = "Внешний слой для клиентов")
public class ClientOuterController {

    private final ClientService clientService;

    @Operation(summary = "Добавить пользователя")
    @PostMapping("/add")
    public ClientDto createClient(ClientDto client) {
        return clientService.createNewClient(client);
    }

    @Operation(summary = "Изменить пользователя")
    @PatchMapping("/change")
    public ClientDto updateClient(Long clientId, ClientDto client) throws ResourceNotFoundException {
        return clientService.changeClient(clientId, client);
    }

    @Operation(summary = "Удалить пользователя")
    @DeleteMapping
    public void deleteClient(Long clientId) {
        clientService.deleteClient(clientId);
    }

    @Operation(summary = "Показать информацию о пользователе")
    @GetMapping
    public ClientDto getClient(Long clientId) {
        return clientService.getClientById(clientId);
    }
}
