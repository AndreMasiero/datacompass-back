package com.datacompass.exception;

import com.datacompass.enums.errorCode.ErrorCode;

public class UserNameUnavaibleException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public UserNameUnavaibleException() {
        super(ErrorCode.USER_NAME_UNAVAILABLE);
    }

}
