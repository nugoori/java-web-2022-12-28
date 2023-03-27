package com.jihoon.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
    //# CORS ( Cross - Origin Resource Sharing ) 정책
    //? 다른 출처의 자원을 공유 할 수 있도록 설정하는 권한 정책
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("*");
    }

}
