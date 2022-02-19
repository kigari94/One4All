package com.haw.one4all.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    // Validating password requirements (1 number, 1 lowercase char, 1 uppercase char, no whitespace)
    private static final String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";

    // Creating pattern from regex
    private static final Pattern pattern = Pattern.compile(regex);

    // Using pattern to validate password matches requirements
    public static boolean isValid(final String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
