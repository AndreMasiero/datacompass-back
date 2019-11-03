package com.datacompass.utils;

import com.datacompass.security.UserSS;

public class AccessValidation {

    public static Boolean validateAccess(String role_) {

        UserSS user = UserAuthenticated.authenticated();

        String role[] = role_.split("ROLE_");

        // Pega a segunda posição sem a palavra ROLE_
        if (!user.hasRole(role[1]))
            return false;

        return true;
    }

}
