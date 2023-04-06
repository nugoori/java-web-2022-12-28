package com.jihoon.board.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class MailProvider {
    
    @Autowired private JavaMailSender javaMailSender;

    public boolean sendMail() {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("122030@donga.ac.kr");
            simpleMailMessage.setTo("lacls159@gmail.com");
            simpleMailMessage.setSubject("제목");
            simpleMailMessage.setText("<p style='color: red;'>html 형식의 내용</p>");
            javaMailSender.send(simpleMailMessage);
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

}
