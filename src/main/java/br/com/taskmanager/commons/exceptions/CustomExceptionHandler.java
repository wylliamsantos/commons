package br.com.taskmanager.commons.exceptions;

import br.com.taskmanager.commons.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleBusinessException(BusinessException ex) {
        var error = new ErrorDTO();
        error.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        error.setMessage(Collections.singletonList(ex.getMessage()));
        return error;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO handleGenericException(Exception ex) {
        var error = new ErrorDTO();
        error.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        error.setMessage(Collections.singletonList(ex.getMessage()));
        return error;
    }
}