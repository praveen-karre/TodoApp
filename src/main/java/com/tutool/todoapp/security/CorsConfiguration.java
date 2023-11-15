package com.tutool.todoapp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class CorsConfiguration {
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
