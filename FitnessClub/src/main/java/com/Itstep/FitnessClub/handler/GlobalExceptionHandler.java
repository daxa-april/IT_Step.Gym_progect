package com.Itstep.FitnessClub.handler;

import com.Itstep.FitnessClub.exception.NoPlaceAvailableException;
import com.Itstep.FitnessClub.exception.ResourceNotFoundException;
import com.Itstep.FitnessClub.exception.SubscriptionExpiredException;
import com.Itstep.FitnessClub.model.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Daria Pevets
 * <p>
 * Обработка исключений
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * NoPlaceAvailableEx + 400.
     */
    @ExceptionHandler(NoPlaceAvailableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto error(NoPlaceAvailableException exception) {
        return new ErrorDto(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    /**
     * SubscriptionExpiredEx + 403.
     */
    @ExceptionHandler(SubscriptionExpiredException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorDto error(SubscriptionExpiredException exception) {
        return new ErrorDto(exception.getMessage(), HttpStatus.FORBIDDEN.value());
    }

    /**
     * ResourceNotFound + 404.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto error(ResourceNotFoundException exception) {
        return new ErrorDto(exception.getMessage(), HttpStatus.NOT_FOUND.value());
    }

}
