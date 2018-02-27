package com.juliodias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class ComplaintServiceApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ComplaintServiceApplication.class, args);
	}
	
	@Configuration
	@Profile("cloud")
	@EnableDiscoveryClient	
	class Config {
	}
	
}
