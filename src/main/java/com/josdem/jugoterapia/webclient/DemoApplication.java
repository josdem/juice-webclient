package com.josdem.jugoterapia.webclient;

import com.josdem.jugoterapia.webclient.service.BeverageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(BeverageService beverageService){
		return args -> {
			beverageService.getBeverage(35L)
					.subscribe(it -> log.info(it.toString()));
		};
	}

}
