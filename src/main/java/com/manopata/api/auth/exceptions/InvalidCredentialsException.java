package com.manopata.api.auth.exceptions;

import com.manopata.api.utlis.codes.ExceptionCodes;
import com.manopata.api.utlis.exceptions.RootException;

public class InvalidCredentialsException extends RootException {

    public InvalidCredentialsException() { super(ExceptionCodes.AUTH_WRONG_CREDENTIALS); }
}
