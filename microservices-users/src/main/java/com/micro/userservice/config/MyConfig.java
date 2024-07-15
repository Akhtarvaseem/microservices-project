package com.micro.userservice.config;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import feign.okhttp.OkHttpClient;

@Configuration
public class MyConfig {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {

		RestTemplate template = new RestTemplate();
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		template.setRequestFactory(requestFactory);

		return template;

	}
	
	
	
	   
}
