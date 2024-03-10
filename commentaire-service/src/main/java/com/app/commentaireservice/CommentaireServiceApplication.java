package com.app.commentaireservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//@EnableFeignClients
@EnableEurekaServer
@SpringBootApplication
public class CommentaireServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommentaireServiceApplication.class, args);
    }

}