package com.manopata.api.utlis.codes;

import lombok.Getter;

public enum ExceptionCodes {

    GENERIC_EXCEPTION_CODE("-1", "Generic exception. Check message below"),
    USER_EMAIL_EXISTS("00001", "This user email is already in use"),
    USER_EMAIL_NOT_EXISTS("00002", "This user email not exists"),
    USER_NICKNAME_EXISTS("00003", "This user nickname is already in use"),
    USER_NOT_EXISTS("00004", "This user doesn't exist yet"),
    ROLE_NOT_EXISTS("00005", "Role not found"),
    AUTH_WRONG_CREDENTIALS("00006", "Invalid credentials"),
    INVALID_TOKEN("00007", "Invalid token");

    @Getter
    private final String errorCode;
    @Getter
    private final String errorMessage;

    private ExceptionCodes(String errorCode, String errorMessage)
    {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
