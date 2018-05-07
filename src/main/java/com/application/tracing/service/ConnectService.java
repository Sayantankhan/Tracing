package com.application.tracing.service;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.application.tracing.bean.RequestBean;

@Service
public class ConnectService {
	
	@Autowired 
	private RestTemplate restTemplate;
	
	public String connectToWs(RequestBean reqBean) {
		HttpHeaders authHeader = createHeaders(reqBean.getUsername(), reqBean.getPwd());
		ResponseEntity<String> response = restTemplate.exchange(reqBean.getUrl(), HttpMethod.GET,
				new HttpEntity<String>(authHeader), String.class);
		return response.getBody();
	}
	
	private HttpHeaders createHeaders(String username, String password) {
		return new HttpHeaders() {
			{
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
	}
}
