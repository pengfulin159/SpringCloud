package com.pfltest.service_miya;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * 测试服务追踪-miya
 *
 */
@SpringBootApplication
@RestController
public class ServiceMiyaApplication{
    public static void main( String[] args ){
    	SpringApplication.run(ServiceMiyaApplication.class, args);
    }
    
    private static final Logger LOG = Logger.getLogger(ServiceMiyaApplication.class.getName());


    @RequestMapping("/hi")
    public String home(){				//提供给hi工程
        LOG.log(Level.INFO, "hi is being called");
        return "hi i'm miya!";
    }

    @RequestMapping("/miya")
    public String info(){				//调用hi工程
        LOG.log(Level.INFO, "info is being called");
        return restTemplate.getForObject("http://localhost:8988/info",String.class);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    
    @Bean 
    public AlwaysSampler defaultSampler(){ 			//图形分析Zipkin
    	return new AlwaysSampler(); 
    } 
}
