package com.github.sttraeger.sqsdemoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.github.sttraeger.sqsdemoserver")
public class Server {

    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }
}
