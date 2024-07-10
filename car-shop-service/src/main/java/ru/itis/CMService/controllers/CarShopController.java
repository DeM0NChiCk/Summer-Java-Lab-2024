package ru.itis.CMService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.CMService.clients.CMClient;
import ru.itis.CMService.clients.DealershipClient;
import ru.itis.CMService.dto.CarShopDto;

@RestController
public class CarShopController {

    @Autowired
    private CMClient carManufClient;

    @Autowired
    private DealershipClient dealershipClient;

    @GetMapping("/car-shop")
    public ResponseEntity<CarShopDto> getCarShop() {
        return ResponseEntity.ok(CarShopDto.builder()
                .carManuf(carManufClient.getCarManufacturer())
                .dealership(dealershipClient.getDealership())
                .build()
        );
    }
}
