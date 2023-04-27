package com.example.ecommercebasket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// eureka
@SpringBootApplication
@EnableDiscoveryClient
public class ECommerceBasketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceBasketApplication.class, args);
    }

}
