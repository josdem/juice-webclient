package com.josdem.jugoterapia.webclient.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
@RequiredArgsConstructor
public class WebClientConfiguration {

    private final ApplicationProperties applicationProperties;

    @Bean
    public WebClient juiceWebClient() {
        return WebClient.builder().baseUrl(applicationProperties.getUrl()).defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE).build();
    }
}
