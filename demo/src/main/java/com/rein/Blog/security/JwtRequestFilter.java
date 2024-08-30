package com.rein.Blog.security;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rein.Blog.service.CustomUserDetailsService;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;



@Component
public class JwtRequestFilter extends OncePerRequestFilter{

    @Autowired
    private CustomUserDetailsService userDetailService;

    @Autowired
    private Jwtutil jwtutil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain chain)
    throws ServletException,IOException {
        final String authorazationHeader = response.getHeader("Authorazation");

        String username = null;
        String jwt = null;

        if(authorazationHeader != null && authorazationHeader.startsWith("Bearer ")) {
            jwt = authorazationHeader.substring(7);
            username = jwtutil.extractUsername(jwt);
        }
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailService.loadUserByUsername(username);

            if (jwtutil.validateToken(jwt, userDetails)) { // check for error 
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }

        }
        chain.doFilter(request, response);

    }

    
}
