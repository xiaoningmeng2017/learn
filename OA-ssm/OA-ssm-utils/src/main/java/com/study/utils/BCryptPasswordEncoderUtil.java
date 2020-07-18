package com.study.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtil {
    private static BCryptPasswordEncoder bCryptPasswordEncoder;

    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }
}
