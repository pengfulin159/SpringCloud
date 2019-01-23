package com.pfltest.server_zipkintest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

/**
 * 用于服务追踪（服务间的调用关系）
 *
 */

@SpringBootApplication
@EnableZipkinServer
public class ServerZipkinApplication {
    public static void main( String[] args ){
    	SpringApplication.run(ServerZipkinApplication.class, args);
    }
}
