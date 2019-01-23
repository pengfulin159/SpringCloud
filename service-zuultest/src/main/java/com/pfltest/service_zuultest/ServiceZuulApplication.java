package com.pfltest.service_zuultest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.pfltest.service_zuultest.filter.MyFilter;

/**
 * 服务网关Zuul的主要功能是路由转发和过滤器
 */

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ServiceZuulApplication {
    public static void main( String[] args ){
    	SpringApplication.run(ServiceZuulApplication.class, args);
    }
    
    @Bean 
    public MyFilter myFilter(){ 		//启动过滤器
    	return new MyFilter(); 
    }
}
