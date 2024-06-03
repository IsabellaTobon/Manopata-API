package com.manopata.api.utlis.exceptions;

import com.manopata.api.utlis.codes.ExceptionCodes;
import lombok.Getter;

public class RootException extends Exception {

    @Getter
    private String errorCode;
    @Getter
    private String errorMessage;

    public RootException(ExceptionCodes exceptionCodes)
    {
        super();
        this.errorCode = exceptionCodes.getErrorCode();
        this.errorMessage = exceptionCodes.getErrorMessage();
    }

    public RootException()
    {
        super();
    }

    @Override
    public String getMessage() { return this.getErrorMessage(); }


}
