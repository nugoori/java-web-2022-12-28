package com.koreait.board.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    public String bcrpyt(String text) {

        String bcryptedText = null;

        try {
            bcryptedText = passwordEncoder.encode(text);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        return bcryptedText;

    }

    public boolean decrypt(String text) {
        
        boolean isMatch = false;

        try {
            isMatch = passwordEncoder.matches("password", text);
        } catch(Exception exception) {
            exception.printStackTrace();
            return false;
        }

        return isMatch;

    }

}
