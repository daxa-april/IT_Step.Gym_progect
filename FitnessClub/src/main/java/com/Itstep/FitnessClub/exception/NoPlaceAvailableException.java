package com.Itstep.FitnessClub.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NoPlaceAvailableException extends RuntimeException {

    private final String message;

}
