package com.thecybersphere.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Allow requests from any origin
        config.addAllowedOrigin("*");

        // Other CORS configurations, if needed
        // config.addAllowedHeader("...");
        // config.addAllowedMethod("...");

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
