package com.manopata.api.auth.exceptions;

import com.manopata.api.utlis.codes.ExceptionCodes;
import com.manopata.api.utlis.exceptions.RootException;

public class InvalidTokenException extends RootException {

    public InvalidTokenException(String invalidToken) { super(ExceptionCodes.AUTH_WRONG_CREDENTIALS); }
}
