package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableMongoRepositories
@SpringBootApplication
@EnableSwagger2

public class OwnerServiceApplication  {

	public static void main(String[] args) {
		SpringApplication.run(OwnerServiceApplication.class, args);
		System.out.println("connected ");
	}
	@Bean
	public RestTemplate restTemplate() {
	return new RestTemplate();
	}

}
