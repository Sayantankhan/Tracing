package com.application.tracing.bean;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestBean {
	
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	private String url;
	private String username;
	@JsonProperty("password")
	private String pwd;
	private Map<String,String> headers;
	private String req_method;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Map<String, String> getHeaders() {
		return headers;
	}
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	public String getReq_method() {
		return req_method;
	}
	public void setReq_method(String req_method) {
		this.req_method = req_method;
	}
	
	@Override
	public String toString() {
		LOG.info("RequestBean [url=" + url + ", req_method="+req_method +", username=" + username + ", pwd=" + pwd + ", headers=" + headers + "]");
		return "RequestBean [url=" + url + ", req_method="+req_method +", username=" + username + ", pwd=" + pwd + ", headers=" + headers + "]";
	}
	
	
}
