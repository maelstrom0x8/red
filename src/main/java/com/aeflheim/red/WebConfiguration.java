package com.aeflheim.red;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.regex.Pattern;

@Configuration
public class WebConfiguration {

    private static final String[] ALLOWED_ENDPOINTS = {
        "/actuator/health"
    };

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        String actuatorPath = Pattern.compile("^\\/actuator(?:\\/[^\\/]*)*$").pattern();

        http.oauth2Login(Customizer.withDefaults());

        http.authorizeHttpRequests(r -> {
            r.requestMatchers(ALLOWED_ENDPOINTS).permitAll();
            r.requestMatchers(actuatorPath).hasAuthority("admin");
            r.anyRequest().authenticated();
        });

        return http.build();
    }

}
