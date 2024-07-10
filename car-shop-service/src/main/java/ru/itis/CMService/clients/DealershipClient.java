package ru.itis.CMService.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.CMService.dto.DealershipDto;

import java.util.List;

@FeignClient("dealership-service")
public interface DealershipClient {
    @RequestMapping("/dealership")
    List<DealershipDto> getDealership();
}
