package com.pvt.dogpark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.pvt.dogpark.dto.Quote;

@Service
public class TrashcanService {

	@Autowired
	RestTemplate restTemplate;
	
	public String getQoute() {
		
	
		WebClient client = WebClient.create("https://gturnquist-quoters.cfapps.io/api/random");
		
		
		Quote quote = restTemplate.getForObject(
				"https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		System.out.println(quote.toString()); //log.info(quote.toString());
		return quote.toString();
	}
}
