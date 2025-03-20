package com.yanvelasco.rasmooplus.exceptions;

import java.io.Serial;

public class IsEmptyException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public IsEmptyException(String message) {
        super(message);
    }
}
