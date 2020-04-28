package com.pvt.dogpark.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TrashcanService {

	@Autowired
	private RestTemplate restTemplate;

	private WebClient webClient;

	public TrashcanService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("https://gturnquist-quoters.cfapps.io/api/random")
				.build();
	}

	public String getQoute() {

		WebClient.UriSpec<WebClient.RequestBodySpec> request = webClient.post();

//		WebClient.RequestBodySpec uri = webClient.post()
//				.uri(URI.create("/"));
//
//		return request.retrieve()
//				.bodyToMono(String.class)
//				.block();

		 return this.webClient.get().retrieve().bodyToMono(String.class).block();

	}

//		return this.webClient.get().url("/{name}/details", name)
//				.retrieve().bodyToMono(Quote.class);
//
//		
//		WebClient client = WebClient.create("https://gturnquist-quoters.cfapps.io/api/random");
//		@Service
//		public class MyService {
//
//			private final WebClient webClient;
//
//	
//			public Mono<Details> someRestCall(String name) {
//				return this.webClient.get().url("/{name}/details", name)
//								.retrieve().bodyToMono(Details.class);
//			}
//
//		}
//		
//		Quote quote = restTemplate.getForObject(
//				"https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//		System.out.println(quote.toString()); //log.info(quote.toString());
//		return quote.toString();
//	}
}
