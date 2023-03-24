package com.koreait.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.board.common.constant.ApiMappingPattern;
import com.koreait.board.provider.TokenProvider;
import com.koreait.board.service.AuthService;

@RestController
@RequestMapping(ApiMappingPattern.AUTH)
public class AuthController {
    
    @Autowired private TokenProvider tokenProvider;

    @Autowired private AuthService authService;

    private static final String GET_TOKEN = "/getToken";
    private static final String VALIDATE_TOKEN = "/validateToken";
    private static final String BCRYPT = "/bcrypt";
    private static final String DECRYPT = "/decrypt";

    @PostMapping(GET_TOKEN)
    public String getToken() {
        return tokenProvider.create();
    }

    @PostMapping(VALIDATE_TOKEN)
    public String validateToken(@RequestBody String requestBody) {
        return tokenProvider.validate(requestBody);
    }

    @PostMapping(BCRYPT)
    public String bcrypt(@RequestBody String requestBody) {
        return authService.bcrpyt(requestBody);
    }

    @PostMapping(DECRYPT)
    public boolean decrypt(@RequestBody String requestBody) {
        return authService.decrypt(requestBody);
    }

}
