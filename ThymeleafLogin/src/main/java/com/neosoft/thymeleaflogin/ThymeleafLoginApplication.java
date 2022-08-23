package com.neosoft.thymeleaflogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.neosoft.thymeleaflogin.controller"})
public class ThymeleafLoginApplication {

    public static void main(String[] args) {

        SpringApplication.run(ThymeleafLoginApplication.class, args);
    }

}
