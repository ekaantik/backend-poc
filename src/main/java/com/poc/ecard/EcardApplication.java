package com.poc.ecard;

import com.poc.ecard.config.TwilioConfig;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories
public class EcardApplication {

	@Autowired
	private TwilioConfig twilioConfig;

	@PostConstruct
	public void initTwilio(){
		Twilio.init(twilioConfig.getAccountSid(),twilioConfig.getAuthToken());
	}

	public static void main(String[] args) {
		SpringApplication.run(EcardApplication.class, args);
	}

//	https://github.com/ekaantik/backend-poc/blob/meet-3/src/main/java/com/poc/ecard/UserServicesImpl.java
}
