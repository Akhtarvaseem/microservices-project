package com.microservices.eureka;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroservicesServerConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesServerConfigApplication.class, args);
	}

}
