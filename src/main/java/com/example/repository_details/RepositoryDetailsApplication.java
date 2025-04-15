package com.example.repository_details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RepositoryDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepositoryDetailsApplication.class, args);
	}

}
