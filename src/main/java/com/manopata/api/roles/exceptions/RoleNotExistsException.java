package com.manopata.api.roles.exceptions;

import com.manopata.api.utlis.codes.ExceptionCodes;
import com.manopata.api.utlis.exceptions.RootException;

public class RoleNotExistsException extends RootException {
    public RoleNotExistsException(String s) { super(ExceptionCodes.ROLE_NOT_EXISTS);}

}
