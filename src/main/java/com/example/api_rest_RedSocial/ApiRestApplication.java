package com.example.api_rest_RedSocial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiRestApplication {

	static final Logger LOGGER = LoggerFactory.getLogger(ApiRestApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
		LOGGER.info("El logger funciona");

//		SerializationFeature.FAIL_ON_EMPTY_BEANS
	}

}
