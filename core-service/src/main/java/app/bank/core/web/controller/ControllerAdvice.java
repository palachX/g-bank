package app.bank.core.web.controller;

import app.bank.common.domain.exception.ResourceAlreadyExistsException;
import app.bank.common.domain.exception.ResourceNotFoundException;
import app.bank.core.web.dto.MessageDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageDto resourceNotFound(final ResourceNotFoundException e) {
        return new MessageDto(e.getMessage() != null ? e.getMessage() : "Not found");
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto resourceNotFound(final ResourceAlreadyExistsException e) {
        return new MessageDto(e.getMessage() != null ? e.getMessage() : "Already exists");
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto illegalState(
            final IllegalStateException e
    ) {
        return new MessageDto(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto illegalState(
            final MethodArgumentNotValidException e
    ) {
        Map<String, String> errors = e.getBindingResult()
                .getFieldErrors().stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        DefaultMessageSourceResolvable::getDefaultMessage,
                        (existingResult, newMessage) -> existingResult + " " + newMessage
                ));


        return new MessageDto("Validation error.", errors);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public MessageDto exception(
            final Exception e
    ) {
        e.printStackTrace();
        return new MessageDto("Internal server error");
    }

}
