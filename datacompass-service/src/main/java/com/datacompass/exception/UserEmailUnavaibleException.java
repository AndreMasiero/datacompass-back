package com.datacompass.exception;

import com.datacompass.enums.errorCode.ErrorCode;

/**
 * Exception que ocorre ao tentar persistir um email já utilizado em outro usuário
 *
 * @author André Masiero
 *
 */
public class UserEmailUnavaibleException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public UserEmailUnavaibleException() {
        super(ErrorCode.USER_EMAIL_UNAVAILABLE);
    }
}

