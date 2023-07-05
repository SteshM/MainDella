package com.SteshM.MainDella.cofiguration;

import com.SteshM.MainDella.filters.CustomAuthenticationFilter;
import com.SteshM.MainDella.filters.CustomAuthorizationFilter;
import jakarta.servlet.FilterChain;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfigurer {
    @Autowired
   private BCryptPasswordEncoder encoder;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    AuthenticationConfiguration authenticationConfiguration;
    public void configurer(AuthenticationManagerBuilder authenticationManagerBuilder)throws Exception{
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }
    @Bean
    public SecurityFilterChain getFilterChain(HttpSecurity http)throws Exception{
        return http
                .csrf((csrf)->csrf.disable())
                .authorizeHttpRequests((authorizeHttpRequests)->authorizeHttpRequests.requestMatchers("/register/**", "/refresh","/login","/hello").permitAll())
                .authorizeHttpRequests((authorizeHttpRequests)->authorizeHttpRequests.anyRequest().authenticated())
                .sessionManagement((sessionManagement)->sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(new CustomAuthenticationFilter(this.getManager()), BasicAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager getManager() throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }
}
