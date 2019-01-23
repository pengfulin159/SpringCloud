package com.pfltest.serice_feigntest.service.fallback;

import org.springframework.stereotype.Component;

import com.pfltest.serice_feigntest.service.SchedualServiceHi;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{

	@Override
	public String sayHiFromClientOne(String name) {
		return name+" this is fegin hystrix error~~~~~~~~~";
	}

}
