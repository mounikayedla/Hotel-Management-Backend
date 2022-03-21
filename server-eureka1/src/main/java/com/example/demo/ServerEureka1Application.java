package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableEurekaServer
@SpringBootApplication
public class ServerEureka1Application {

	public static void main(String[] args) {
		SpringApplication.run(ServerEureka1Application.class, args);
	}

}
