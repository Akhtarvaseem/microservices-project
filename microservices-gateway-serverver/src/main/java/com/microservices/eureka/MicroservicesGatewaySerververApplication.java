package com.microservices.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicesGatewaySerververApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesGatewaySerververApplication.class, args);
	}

}
