package ru.itis.CMService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarShopDto {
    private List<CarManufDto> carManuf;
    private List<DealershipDto> dealership;
}
