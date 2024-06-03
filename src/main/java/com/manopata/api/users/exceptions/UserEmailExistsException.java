package com.manopata.api.users.exceptions;

import com.manopata.api.utlis.codes.ExceptionCodes;
import com.manopata.api.utlis.exceptions.RootException;

public class UserEmailExistsException extends RootException {

    public UserEmailExistsException() { super(ExceptionCodes.USER_EMAIL_EXISTS); }
}
