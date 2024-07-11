package ru.itis.CMService.controllers;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.CMService.clients.CMClient;
import ru.itis.CMService.clients.DealershipClient;
import ru.itis.CMService.dto.CarShopDto;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

import static ru.itis.CMService.CarShopServiceApplication.MSG_TOPIC;

//@RequiredArgsConstructor
@RestController
@Slf4j
public class CarShopController {

    @Autowired
    private CMClient carManufClient;

    @Autowired
    private DealershipClient dealershipClient;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/car-shop")
    public ResponseEntity<String> getCarShop() {
        CarShopDto response = CarShopDto.builder()
                .carManuf(carManufClient.getCarManufacturer())
                .dealership(dealershipClient.getDealership())
                .build();

        CompletableFuture<SendResult<String, String>> msgSendResult= kafkaTemplate.send(MSG_TOPIC, response.toString());

        msgSendResult.whenComplete((stringCarShopDtoSendResult, throwable) -> {
            if (throwable != null) {
                log.error("Error while producing", throwable);
            } else {
                ProducerRecord<String, String> record = stringCarShopDtoSendResult.getProducerRecord();
                RecordMetadata recordMetadata = stringCarShopDtoSendResult.getRecordMetadata();
                log.info("{} {}", record.value(), recordMetadata);
            }
        });

        return ResponseEntity.ok("Каталог обновлён!");
    }



}
