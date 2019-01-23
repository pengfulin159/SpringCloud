package com.pfltest.config_clienttest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试从配置中心config-server获取 文件信息
 *
 */

@SpringBootApplication
@RestController
public class ConfigClientApplication {
    public static void main( String[] args ){
    	SpringApplication.run(ConfigClientApplication.class, args);
    }
    
    @Value("${foo}")
    String foo;
    
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }
}
