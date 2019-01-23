package com.pfltest.service_ribbontest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*
 * 服务消费者 --Ribbon
 */
@SpringBootApplication
@EnableDiscoveryClient		//通过@EnableDiscoveryClient向服务中心注册
@EnableHystrix
@EnableHystrixDashboard		//熔断追踪器（图形化展示）
public class ServiceRibbonApplication {
	 public static void main(String[] args) {
		 SpringApplication.run(ServiceRibbonApplication.class, args);
	 }
	 
	 //当sercvice-ribbon通过restTemplate调用service-hi的hi接口时，因为用ribbon进行了负载均衡，会轮流的调用service-hi：8762和8763 两个端口的hi接口
	 @Bean					//向程序的ioc注入一个bean: restTemplate
	 @LoadBalanced			//LoadBalanced注解表明这个restRemplate开启负载均衡的功能。		
	 RestTemplate restTemplate() {
		 return new RestTemplate();
	 }
	 
}
