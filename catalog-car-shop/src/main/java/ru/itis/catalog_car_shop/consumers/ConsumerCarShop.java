package ru.itis.catalog_car_shop.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ConsumerCarShop {

    @KafkaListener(topics = "message", groupId = "messageGroupId")
    public void listenCarShop(@Payload String message) {
        System.out.println("Message: " + message);
    }
}
