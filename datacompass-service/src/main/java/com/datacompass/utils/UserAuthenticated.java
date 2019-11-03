package com.datacompass.utils;

import com.datacompass.security.UserSS;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserAuthenticated {

    public static UserSS authenticated() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }
}
