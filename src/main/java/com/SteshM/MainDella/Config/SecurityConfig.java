package com.SteshM.MainDella.Config;

import com.SteshM.MainDella.filter.Authentication;
import com.SteshM.MainDella.filter.JwtAuthFilter;
import com.SteshM.MainDella.services.UsersServices;
import com.SteshM.MainDella.utilities.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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
@AllArgsConstructor
@NoArgsConstructor
public class SecurityConfig {
@Autowired
    AuthenticationConfiguration config;
@Autowired
UserDetailsService userDetailsService;
    @Autowired
    BCryptPasswordEncoder encoder;
public void createBuilder(AuthenticationManagerBuilder builder)throws Exception{
builder.userDetailsService(userDetailsService).passwordEncoder(encoder);
}

    @Autowired
    JwtUtil jwtUtil;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                    .csrf((csrf)-> csrf.disable())
                    .authorizeHttpRequests((authorizeHttpRequests)->authorizeHttpRequests.requestMatchers("/login","/v1/**").permitAll())
                    .authorizeHttpRequests((authorizeHttpRequests)->authorizeHttpRequests.requestMatchers("/admin/**").hasAnyAuthority("Admin"))
                    .authorizeHttpRequests((authorizeHttpRequests)->authorizeHttpRequests.requestMatchers("/welcome/**").hasAnyAuthority("Tutor","Learner"))
                    .authorizeHttpRequests((authorizeHttpRequests)->authorizeHttpRequests.anyRequest().authenticated())
                    .sessionManagement((sessionManagement)->sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                    .authenticationProvider(authenticationProvider())
                .addFilterBefore(new JwtAuthFilter() , UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(new Authentication(this.authenticationManager(), jwtUtil), BasicAuthenticationFilter.class)
                    .build();
    }


//    @Bean
//    public AuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return config.getAuthenticationManager();
    }
}
