package com.pvt.dogpark;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pvt.dogpark.dto.Quote;

@RestController
@SpringBootApplication
public class DogParkApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DogParkApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DogParkApplication.class, args);
	}

	
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			System.out.println(quote.toString()); //log.info(quote.toString());
		};
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/goodbye")
	public String goodbye(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Goodbye %s!", name);
	}

	@GetMapping("/Ciao")
	public String ciao(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Ciao %s!", name);
	}

}
