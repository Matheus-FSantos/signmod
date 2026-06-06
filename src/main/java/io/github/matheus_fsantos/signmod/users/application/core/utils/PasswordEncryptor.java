package io.github.matheus_fsantos.signmod.users.application.core.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class PasswordEncryptor {
    public static String encrypt(String password) {
        try {
            byte[] hashBytes = MessageDigest.getInstance("SHA-256")
                    .digest(password.getBytes(StandardCharsets.UTF_8));

            return HexFormat.of().formatHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("error initializing the SHA-256 algorithm.", e);
        }
    }
}
