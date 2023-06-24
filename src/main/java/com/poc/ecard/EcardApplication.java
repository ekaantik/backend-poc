package com.poc.ecard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.poc.ecard")
@EntityScan("com.poc.ecard")
public class EcardApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcardApplication.class, args);
	}

}