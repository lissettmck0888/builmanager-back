package com.gi.builmanager.security;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter implements Filter {

    @Autowired
    private JwtManager jwtManager;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String tokenAttr = ((HttpServletRequest)servletRequest).getHeader("Authorization");

        try {
            if(tokenAttr != null && !tokenAttr.isEmpty()){
                String token = tokenAttr.substring("Bearer ".length() -1);
                UserData userData = jwtManager.parseUserDataFunction(token);

                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userData, null, null);
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) servletRequest));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }catch (ExpiredJwtException ex) { }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
