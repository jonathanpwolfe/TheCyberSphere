package com.thecybersphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TheCyberSphereApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheCyberSphereApplication.class, args);
	}

}
