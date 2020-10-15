package com.example.testoweapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TestoweApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestoweApiApplication.class, args);
	}

}
