package com.senla.catalog.configuration.filter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.senla.catalog.dto.auth.AuthRequestDto;
import com.senla.catalog.service.security.token.TokenUtil;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class AuthFilter extends UsernamePasswordAuthenticationFilter {

    private String login;
    private String password;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        super.doFilter(req, res, chain);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        ObjectMapper objectMapper = new ObjectMapper();

        try (BufferedReader reader = request.getReader()) {
            String requestBody = reader.lines().collect(Collectors.joining());
            AuthRequestDto authRequest = objectMapper.readValue(requestBody, AuthRequestDto.class);

            login = authRequest.getLogin();
            password = authRequest.getPassword();

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login, password);
            setDetails(request, token);

            return this.getAuthenticationManager().authenticate(token);

        } catch (JsonParseException | JsonMappingException je) {
            throw new AuthenticationServiceException("Json exception: " + je.getMessage());

        } catch (IOException ioe) {
            throw new AuthenticationServiceException("IOException: " + ioe.getMessage());

        } catch (AuthenticationException e) {
            throw new AuthenticationServiceException("Authentication exception: " + e.getMessage());
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authentication) throws IOException, ServletException {
        ObjectMapper objectMapper = new ObjectMapper();

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");

        out.print(objectMapper.writeValueAsString(TokenUtil.create(login, password)));
        out.flush();

        super.successfulAuthentication(request, response, filterChain, authentication);
    }
}