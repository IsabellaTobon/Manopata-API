package com.manopata.api.exceptions.controller;

import com.manopata.api.exceptions.dto.ExceptionResponse;
import com.manopata.api.utlis.codes.ExceptionCodes;
import com.manopata.api.utlis.exceptions.RootException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class HandledExceptionController extends ExceptionController
{
    @ExceptionHandler({RootException.class})
    public ResponseEntity getCustomExceptionsWithThreeParamsResponse(RootException e)
    {
        log.error(e.getClass() + e.getErrorCode() + ": " + e.getErrorMessage());
        return new ResponseEntity(new ExceptionResponse(e.getErrorCode(), e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity getException(Exception e)
    {
        log.error(e.getClass() + ExceptionCodes.GENERIC_EXCEPTION_CODE.getErrorCode() + ": " + e.getMessage());
        return new ResponseEntity(new ExceptionResponse(ExceptionCodes.GENERIC_EXCEPTION_CODE.getErrorCode(), e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }
}
