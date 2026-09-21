package com.Itstep.FitnessClub.model.dto;

/**
 * @author Daria Pevets
 **/
public record ClientInnerDto(
        Long id,
        String fullName,
        String email,
        String phone,
        Integer trainingsLeft
) {
}
