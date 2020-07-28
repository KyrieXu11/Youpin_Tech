package com.kyriexu.utils;

import com.kyriexu.model.User;
import org.springframework.util.StringUtils;

/**
 * @author KyrieXu
 * @since 2020/7/28 15:02
 **/
public class ValidateUserInfo {
    public static boolean validateUsername(String username) {
        return StringUtils.hasText(username);
    }

    public static boolean validatePassword(String password) {
        return StringUtils.hasText(password) && password.length() > 8;
    }

    public static boolean validateEmail(String email) {
        if(StringUtils.hasText(email))
            return email.matches("[a-zA-Z0-9_-]+");
        return true;

    }

    public static boolean validateUser(User user) {
        return validateEmail(user.getEmail()) && validateUsername(user.getUsername()) && validatePassword(user.getPassword());
    }
}
