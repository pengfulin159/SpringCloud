package com.pfltest.service_turbinetest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 断路器聚合监控(Hystrix Turbine)
 */
@SpringBootApplication
@EnableTurbine
public class ServiceTurbineApplication {
    public static void main( String[] args ){
    	new SpringApplicationBuilder(ServiceTurbineApplication.class).web(true).run(args);
    }
}
