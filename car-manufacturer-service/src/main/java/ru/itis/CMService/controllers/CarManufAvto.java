package ru.itis.CMService.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.CMService.dto.CarManufDto;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/car-manufacturer")
@Slf4j
public class CarManufAvto {

    @GetMapping
    public ResponseEntity<List<CarManufDto>> getCarManufacturer() {
        log.info("Get response for car manufacturer");
        return ResponseEntity.ok(Arrays.asList(
                CarManufDto.builder().id(1L).country("China").title("Jack").build(),
                CarManufDto.builder().id(2L).country("Rassia").title("LADA").build(),
                CarManufDto.builder().id(3L).country("Japan").title("Toyta").build(),
                CarManufDto.builder().id(4L).country("Germany").title("BMW").build(),
                CarManufDto.builder().id(5L).country("Germany").title("Mercedes-Benz").build(),
                CarManufDto.builder().id(6L).country("Italy").title("Lamborghini").build()
        ));
    }
}
