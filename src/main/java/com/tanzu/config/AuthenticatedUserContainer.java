package com.tanzu.config;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AuthenticatedUserContainer {
    private static final MapThreadLocal<String> authenticatedUser = new MapThreadLocal<>();
    private static String username;

    public static void setAuthenticatedUser(String token, String username) {
        Map<String, String> map = authenticatedUser.get();
        map.put(token, username);
        authenticatedUser.set(map);
    }

    public static String getAuthenticatedUser(String token) {
        Map<String, String> map = authenticatedUser.get();
        if (map != null) {
            return map.get(token);
        }
        return null;
    }

    public static void removeAuthenticatedUser(String token) {
        authenticatedUser.removeValue(token);
    }

    public static void clearAuthenticatedUser() {
        authenticatedUser.remove();
    }
}