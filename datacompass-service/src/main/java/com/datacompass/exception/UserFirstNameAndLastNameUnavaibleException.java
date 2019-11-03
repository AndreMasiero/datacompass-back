package com.datacompass.exception;

import com.datacompass.enums.errorCode.ErrorCode;

public class UserFirstNameAndLastNameUnavaibleException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public UserFirstNameAndLastNameUnavaibleException() {
        super(ErrorCode.USER_FIRST_NAME_AND_LAST_NAME_UNAVAILABLE);
    }

}
