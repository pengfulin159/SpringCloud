package com.pfltest.serice_feigntest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 服务消费者 --feign
 */
@SpringBootApplication
@EnableDiscoveryClient				//通过@EnableDiscoveryClient向服务中心注册
@EnableFeignClients					//加上@EnableFeignClients注解开启Feign的功能
@EnableHystrixDashboard				//熔断追踪器（图形化展示）
@EnableCircuitBreaker				//熔断追踪器（图形化展示）  解决Unable to connect to Command Metric Stream.
public class ServiceFeignApplication {
	public static void main(String[] args) {
        SpringApplication.run(ServiceFeignApplication.class, args);
    }
}
