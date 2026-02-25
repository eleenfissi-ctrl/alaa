package com.alaa.parfum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.alaa.entities")           
@EnableJpaRepositories("com.alaa.repos")   
public class ParfumApplication {
    public static void main(String[] args) {
        SpringApplication.run(ParfumApplication.class, args);
    }
}