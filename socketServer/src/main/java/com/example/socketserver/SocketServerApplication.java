package com.example.socketserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "com.example.socketserver.mapper")
public class SocketServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocketServerApplication.class, args);
    }

}
