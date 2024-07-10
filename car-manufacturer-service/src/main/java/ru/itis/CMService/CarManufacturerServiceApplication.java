package ru.itis.CMService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CarManufacturerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarManufacturerServiceApplication.class, args);
    }

}
