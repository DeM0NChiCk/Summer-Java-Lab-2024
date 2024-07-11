package ru.itis.DService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DealershipDto {
    private Long id;
    private String title;
    private String city;
    private String country;
}
