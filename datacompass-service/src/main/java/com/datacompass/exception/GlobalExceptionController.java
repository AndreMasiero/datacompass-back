package com.datacompass.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UserEmailUnavaibleException.class, UserFirstNameAndLastNameUnavaibleException.class, UserNameUnavaibleException.class})
    public ResponseEntity<Object> handleErrorBadRequest(BusinessException businessException, WebRequest request) {
        return handleExceptionInternal(businessException, new ErrorVO(businessException), this.getHttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        return httpHeaders;
    }

}
