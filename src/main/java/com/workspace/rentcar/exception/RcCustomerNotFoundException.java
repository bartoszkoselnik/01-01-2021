package com.workspace.rentcar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Customer Not Found")
public class RcCustomerNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public RcCustomerNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
