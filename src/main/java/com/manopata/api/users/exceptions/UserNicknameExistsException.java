package com.manopata.api.users.exceptions;

import com.manopata.api.utlis.codes.ExceptionCodes;
import com.manopata.api.utlis.exceptions.RootException;

public class UserNicknameExistsException extends RootException {

    public UserNicknameExistsException() { super(ExceptionCodes.USER_NICKNAME_EXISTS); }
}
