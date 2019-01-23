package com.pfltest.service_hitest2;


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
 * 测试服务追踪-hi2
 */
@SpringBootApplication
@RestController				//对外暴露接口
public class ServiceHi2Application{
    public static void main( String[] args ){
    	SpringApplication.run(ServiceHi2Application.class, args);
    }
    
    private static final Logger LOG = Logger.getLogger(ServiceHi2Application.class.getName());
    
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    
    @RequestMapping("/hi")
    public String callHome(){				//调用另一个服务miya
        LOG.log(Level.INFO, "calling trace service-hi  ");
        return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }
    
    @RequestMapping("/info")
    public String info(){					//提供给miya调用
        LOG.log(Level.INFO, "calling trace service-hi ");
        return "i'm service-hi2";
    }
    
    @Bean
    public AlwaysSampler defaultSampler(){			//图形分析Zipkin
        return new AlwaysSampler();
    }
    
}
