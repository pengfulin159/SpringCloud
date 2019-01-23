package com.pfltest.service_lucytest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/*
 * 服务提供者		--跟service hi 一毛一样		主要用于测试Hystrix Turbine。（ 断路器聚合监控）
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix						//注解开启断路器			程序中声明断路点	@HystrixCommand
@EnableHystrixDashboard				//@EnableHystrixDashboard注解，开启HystrixDashboard
public class ServiceLucyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceLucyApplication.class, args);
    }

    @Value("${server.port}")
    String port;
    
    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }
    
    public String hiError(String name){
    	return "hi,"+name+",sorry,error!";
    }

}
