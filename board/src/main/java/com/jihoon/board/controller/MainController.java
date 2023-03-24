package com.jihoon.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jihoon.board.provider.MailProvider;

@RestController
@RequestMapping("/api")
public class MainController {
    
    @Autowired private MailProvider mailProvider;

    @GetMapping("")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/send-mail")
    public boolean sendMail() {
        return mailProvider.sendMail();
    }



}
