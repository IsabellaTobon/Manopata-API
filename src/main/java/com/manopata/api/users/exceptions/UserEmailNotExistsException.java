package com.manopata.api.users.exceptions;

import com.manopata.api.utlis.codes.ExceptionCodes;
import com.manopata.api.utlis.exceptions.RootException;

public class UserEmailNotExistsException extends RootException {

    public UserEmailNotExistsException() { super(ExceptionCodes.USER_EMAIL_NOT_EXISTS); }
}
