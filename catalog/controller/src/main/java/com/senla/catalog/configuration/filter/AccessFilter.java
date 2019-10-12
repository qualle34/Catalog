package com.senla.catalog.configuration.filter;

import com.senla.catalog.service.security.token.TokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

public class AccessFilter extends BasicAuthenticationFilter {

    public AccessFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String encodedToken = request.getHeader("token");
        UsernamePasswordAuthenticationToken token = getAuthentication(encodedToken);

        if (encodedToken != null) {
            Authentication authentication = this.getAuthenticationManager().authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            filterChain.doFilter(request, response);

        } else {
            token.setAuthenticated(false);
            SecurityContextHolder.getContext().setAuthentication(token);
            filterChain.doFilter(request, response);
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String encodedToken) {
        return new UsernamePasswordAuthenticationToken(TokenUtil.getLogin(encodedToken), TokenUtil.getPassword(encodedToken), new HashSet<>());
    }
}
