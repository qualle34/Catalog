package com.senla.catalog.service.security.token;

import com.senla.catalog.dto.auth.TokenDto;

import java.util.Base64;
import java.util.Objects;

public class TokenUtil {

    private static final String separator = ":";

    public static TokenDto create(String login, String password) {
        long time = System.currentTimeMillis() + 3600000; // one hour
        String tokenString = login + separator + password + separator + time;
        String encodedToken = Base64.getEncoder().encodeToString(tokenString.getBytes());

        return new TokenDto(encodedToken);
    }

    public static String getLogin(String encodedToken) {
        return getPart(encodedToken, 0);
    }

    public static String getPassword(String encodedToken) {
        return getPart(encodedToken, 1);
    }

    public static boolean isValid(String encodedToken) {
        return encodedToken != null && !encodedToken.equals("") && Long.parseLong(Objects.requireNonNull(getPart(encodedToken, 2))) > System.currentTimeMillis();
    }

    private static String getPart(String encodedToken, int part) {

        try {
            byte[] login = Base64.getDecoder().decode(encodedToken);
            String token = new String(login);
            String[] arr = token.split(separator);
            return arr[part];

        } catch (RuntimeException e) {
            return null;
        }
    }
}