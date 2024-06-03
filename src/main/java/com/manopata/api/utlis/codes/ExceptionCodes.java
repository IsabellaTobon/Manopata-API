package com.manopata.api.utlis.codes;

import lombok.Getter;

public enum ExceptionCodes {

    USER_EMAIL_EXISTS("00001", "This user email is already in use"),
    USER_EMAIL_NOT_EXISTS("00002", "This user email not exists"),
    USER_NICKNAME_EXISTS("00003", "This user nickname is already in use"),
    USER_NOT_EXISTS("00004", "This user doesn't exist yet");

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
