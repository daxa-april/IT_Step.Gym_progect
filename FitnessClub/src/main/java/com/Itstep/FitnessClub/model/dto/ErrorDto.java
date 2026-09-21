package com.Itstep.FitnessClub.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author Daria Pevets
 * <p>
 * Тело ошибок
 **/
@Getter
@Setter
@RequiredArgsConstructor
public class ErrorDto {

    private final String errorMessage;

    private final Integer errorCode;
}
