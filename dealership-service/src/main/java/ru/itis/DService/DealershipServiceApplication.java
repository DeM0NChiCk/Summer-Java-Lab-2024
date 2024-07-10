package ru.itis.DService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@EnableDiscoveryClient
@SpringBootApplication
public class DealershipServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DealershipServiceApplication.class, args);
    }

}
