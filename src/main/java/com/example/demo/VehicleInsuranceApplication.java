package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan("com.example")
@EntityScan("com.example.entity") 
@EnableJpaRepositories("com.example.repository") 
public class VehicleInsuranceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleInsuranceApplication.class, args);
	}

}
