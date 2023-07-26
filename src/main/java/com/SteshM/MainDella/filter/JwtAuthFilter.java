package com.SteshM.MainDella.filter;

import com.SteshM.MainDella.services.UsersServices;
import com.SteshM.MainDella.utilities.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;

    @Autowired
    public UsersServices userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (request.getServletPath().equals("/v1/paths")||request.getServletPath().equals("/v1/user/register")||request.getServletPath().equals("/login")) {
            System.out.println("in filter");
filterChain.doFilter(request, response);
        } else {
           if(request.getHeader("Authorization") != null ){
               if(request.getHeader("Authorization").startsWith("Bearer ")){
                   String token = null;
                   String username = null;
                   token = authHeader.substring(7);
                   try{
                       username = jwtUtil.extractUsername(token);
                       if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                           UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                           if (jwtUtil.validateToken(token, userDetails)) {
                               UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                               authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                               SecurityContextHolder.getContext().setAuthentication(authToken);
                           }
                       }
                       filterChain.doFilter(request, response);
                   }catch(Exception e){
                       System.out.println(e.getMessage());
                   }

               }else{
                   System.out.println("token must be bearer");
               }

           }else{
               System.out.println("there is no authorization header");
           }
        }
    }
}

