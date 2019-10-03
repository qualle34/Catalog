package com.senla.catalog.configuration;

import com.senla.catalog.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http
//                .authorizeRequests().anyRequest().authenticated()
//                .and()
//                .httpBasic();
//
//        http.csrf()
//                .disable()
//                // указываем правила запросов
//                // по которым будет определятся доступ к ресурсам и остальным данным
//                .authorizeRequests()
//                .antMatchers("/resources/**", "/**").permitAll()
//                .anyRequest().permitAll()
//                .and();
//
//        http.formLogin()
//                // указываем страницу с формой логина
//                .loginPage("/login")
//                // указываем action с формы логина
//                .loginProcessingUrl("/j_spring_security_check")
//                // указываем URL при неудачном логине
//                .failureUrl("/login?error")
//                // Указываем параметры логина и пароля с формы логина
//                .usernameParameter("j_username")
//                .passwordParameter("j_password")
//                // даем доступ к форме логина всем
//                .permitAll();
//
//        http.logout()
//                // разрешаем делать логаут всем
//                .permitAll()
//                // указываем URL логаута
//                .logoutUrl("/logout")
//                // указываем URL при удачном логауте
//                .logoutSuccessUrl("/login?logout")
//                // делаем не валидной текущую сессию
//                .invalidateHttpSession(true);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
