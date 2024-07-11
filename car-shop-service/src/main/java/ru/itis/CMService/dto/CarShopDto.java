package ru.itis.CMService.dto;

import jakarta.persistence.Column;
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
    @Column(name = "carManuf")
    private List<CarManufDto> carManuf;
    @Column(name = "dealership")
    private List<DealershipDto> dealership;
}
