package com.workspace.rentcar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Car not available")
public class RcCarNotAvailableException extends Exception{
    private static final long serialVersionUID = 1L;

    public RcCarNotAvailableException(String errorMessage){
        super(errorMessage);
    }
}
