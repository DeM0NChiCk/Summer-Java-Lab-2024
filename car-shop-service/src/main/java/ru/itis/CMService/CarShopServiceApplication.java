package ru.itis.CMService;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class CarShopServiceApplication {

    public static final String MSG_TOPIC = "message";

    @Bean
    public NewTopic msgTopic() {
        return new NewTopic(MSG_TOPIC, 1, (short) 1);
    }

    public static void main(String[] args) {
        SpringApplication.run(CarShopServiceApplication.class, args);
    }

}
