package com.manopata.api.exceptions.controller;

import com.manopata.api.exceptions.dto.ExceptionResponse;
import com.manopata.api.utlis.codes.ExceptionCodes;

public class ExceptionController
{
    protected ExceptionResponse getInternalExceptionHandlerData(ExceptionCodes errorCode)
    {
        return  new ExceptionResponse(errorCode);
    }
}
