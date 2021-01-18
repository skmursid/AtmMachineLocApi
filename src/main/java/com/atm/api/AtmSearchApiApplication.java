package com.atm.api;

import com.atm.api.dao.AtmSearchDao;
import com.atm.api.dao.AtmSearchDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AtmSearchApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(AtmSearchApiApplication.class, args);
	}

	@Bean
	public AtmSearchDao atmSearchDao()
	{
		return new AtmSearchDaoImpl();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder)
	{
		return builder.build();
	}

}
