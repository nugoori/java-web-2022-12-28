package com.koreait.board.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
    value=HttpStatus.UNAUTHORIZED,
    reason="Need Autorization"
)
public class UnauthorizationException extends RuntimeException {
    public UnauthorizationException() {
        super("Authentication is Required");
    }
}
