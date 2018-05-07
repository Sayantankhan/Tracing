package com.application.tracing.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.application.tracing.bean.RequestBean;
import com.application.tracing.service.ConnectService;

@RestController
public class DummyExposerEndpoint {

	@Autowired
	private ConnectService service;
	
	@GetMapping("/get")
	public ResponseEntity<String> getRequest() {
		//String response = restTemplate.getForObject("http://maps.googleapis.com/maps/api/geocode/json?address=Chicago", String.class);
		return new ResponseEntity<String>("Get Response Generated",HttpStatus.OK);
	}
	
	@PostMapping(path="/post",consumes="application/json",produces="application/json")
	public ResponseEntity<String> getPostRequest(@RequestBody RequestBean reqBean){
		String response = service.connectToWs(reqBean);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
