package com.pfltest.service_ribbontest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "hiError")
	public String getServiceInfo(String name){
		System.out.println("2");
		String result=restTemplate.getForObject("http://SERVICE-HI/hi?name="+name, String.class);
		System.out.println("3");
		return result;
	}
	
	public String hiError(String name){
		return name+"  this is hystrix error~~~~~~~~~";
	}
}
