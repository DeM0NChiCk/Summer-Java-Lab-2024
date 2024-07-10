package ru.itis.CMService.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.CMService.dto.CarManufDto;

import java.util.List;

@FeignClient("car-manufacturer-service")
public interface CMClient {
    @RequestMapping("/car-manufacturer")
    List<CarManufDto> getCarManufacturer();
}
