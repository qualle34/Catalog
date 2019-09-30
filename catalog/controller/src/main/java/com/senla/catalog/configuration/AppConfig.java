package com.senla.catalog.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.senla.catalog" })
public class AppConfig {

    @Bean
    ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
