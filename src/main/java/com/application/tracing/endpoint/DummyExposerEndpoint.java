package com.application.tracing.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DummyExposerEndpoint {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/get")
	public ResponseEntity<String> getRequest() {
		String response = restTemplate.getForObject("http://maps.googleapis.com/maps/api/geocode/json?address=Chicago", String.class);
		return new ResponseEntity<String>("Get Response Generated",HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> getPostRequest(){
		return new ResponseEntity<String>("Post Response Generated",HttpStatus.OK);
	}
}
