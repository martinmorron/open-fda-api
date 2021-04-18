package com.martinmorron.openfdaapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Value("${openfda.api.key}")
    private String apiKey;

    @Bean
    public RestTemplate restTemplate(final RestTemplateBuilder builder) {
        return builder
                .defaultHeader("Authorization", "Basic: " + this.apiKey)
                .build();
    }
}
