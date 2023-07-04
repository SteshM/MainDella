package com.SteshM.MainDella.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

public class CustomAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
if(request.getServletPath().equals("/register/Admin") ||
        request.getServletPath().equals("/register/Tutor")||
        request.getServletPath().equals("/register/Learner")||
        request.getServletPath().equals("/login")  ||
        request.getServletPath().equals("/hello")){
    filterChain.doFilter(request,response);
        }else{
    String authHeader = request.getHeader("Authorization");
    if(authHeader == null){
        //response no header
    }else if(authHeader.startsWith("Bearer ")){
        String token = authHeader.substring("Bearer ".length());
        try{
            Algorithm algo = Algorithm.HMAC256("secret".getBytes());
            JWTVerifier verifier = JWT.require(algo).build();
            DecodedJWT decoded = verifier.verify(token);
            ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
            String[] roles = decoded.getClaim("role").asArray(String.class);
            for(String role: roles){
                authorities.add(new SimpleGrantedAuthority(role));
            }
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(decoded.getSubject(), decoded.getClaim("role"));
            SecurityContextHolder.getContext().setAuthentication(authToken);
            filterChain.doFilter(request, response);
        }catch(Exception e){
            //result for error
        }
    }else{
        //response for no bearer
    }
        }
    }
}
