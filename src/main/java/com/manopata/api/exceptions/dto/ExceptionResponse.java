package com.manopata.api.exceptions.dto;

import com.manopata.api.utlis.codes.ExceptionCodes;
import lombok.Data;

@Data
public class ExceptionResponse
{
    private String message;
    private String code;

    public ExceptionResponse() {}

    public ExceptionResponse(String code, String message)
    {
        this.setCode(code);
        this.setMessage(message);
    }

    public ExceptionResponse(ExceptionCodes exceptionCodes)
    {
        this.setCode(exceptionCodes.getErrorCode());
        this.setMessage(exceptionCodes.getErrorMessage());
    }
}
