package com.devopstest.util;


import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {


    SCryptPasswordEncoder encoder = new SCryptPasswordEncoder();



    public String encrypt(String nonEncryptedPassword){


        String encodedPassword = encoder.encode(nonEncryptedPassword);

        return  encodedPassword;

    }



}
