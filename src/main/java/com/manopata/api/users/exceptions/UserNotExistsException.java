package com.manopata.api.users.exceptions;

import com.manopata.api.utlis.codes.ExceptionCodes;
import com.manopata.api.utlis.exceptions.RootException;

public class UserNotExistsException extends RootException {

    public UserNotExistsException() { super(ExceptionCodes.USER_NOT_EXISTS); }
}
