package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                // Route for exploitations-service
                .route("exploitations-service", r -> r
                        .path("/api/exploitations/**", "/api/parcelles/**")
                        .uri("lb://EXPLOITATIONS-SERVICE")) 

                // Route for supervision-service
                .route("supervision-service", r -> r
                        .path("/api/donnees-capteur/**", "/api/donnees-meteo/**")
                        .uri("lb://SUPERVISION-SERVICE"))
                .route("supervision-anomalies", r -> r
                        .path("/api/anomalies/**")
                        .uri("lb://SUPERVISION-SERVICE"))

                .build();
    }

}
