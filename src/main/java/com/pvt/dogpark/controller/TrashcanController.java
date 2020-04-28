package com.pvt.dogpark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pvt.dogpark.service.TrashcanService;

@RestController
@RequestMapping(path = "/trashcan")
public class TrashcanController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	TrashcanService service;
	
	@GetMapping(path = "", params = "all")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(service.getQoute());
	}
}
