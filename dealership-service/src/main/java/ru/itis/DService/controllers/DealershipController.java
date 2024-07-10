package ru.itis.DService.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.DService.dto.DealershipDto;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/dealership")
@Slf4j
public class DealershipController {
    @GetMapping
    public ResponseEntity<List<DealershipDto>> getDealership() {
        log.info("Get response for dealership");
        return ResponseEntity.ok(Arrays.asList(
                DealershipDto.builder().title("AziaAvto").city("Kazan").id(1L).build(),
                DealershipDto.builder().title("RusAvto").city("Tolyatti").id(2L).build(),
                DealershipDto.builder().title("BMWAvto").city("Moscow").id(3L).build(),
                DealershipDto.builder().title("Mercedes-BenzAvto").city("Moscow").id(4L).build(),
                DealershipDto.builder().title("ToyotaAvto").city("Vladivostok").id(5L).build(),
                DealershipDto.builder().title("PremAvtoAvto").city("Kazan").id(6L).build()
        ));
    }
}
