package com.SteshM.MainDella.cofiguration;

import jakarta.servlet.FilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {
    @Bean
    public SecurityFilterChain getFilterChain(HttpSecurity http)throws Exception{
        return http
                .csrf((csrf)->csrf.disable())
                .authorizeHttpRequests((authorizeHttpRequests)->authorizeHttpRequests.anyRequest().authenticated())
                .sessionManagement((sessionManagement)->sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}
