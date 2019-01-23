package com.pfltest.service_ribbontest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pfltest.service_ribbontest.service.HelloService;

@RestController
public class HelloControler {
	
	@Autowired
	HelloService helloService;
	
	@RequestMapping(value = "/hiCall")
	public String hi(@RequestParam String name){
		System.out.println("1");
		return helloService.getServiceInfo(name);
	}

}
