package com.juliodias.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	@Bean
	public GatewayFilter gatewayFilter() {
		return new GatewayFilter();
	}
}
