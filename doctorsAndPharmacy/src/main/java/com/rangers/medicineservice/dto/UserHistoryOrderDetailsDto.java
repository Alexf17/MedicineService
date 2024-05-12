package com.rangers.medicineservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserHistoryOrderDetailsDto {
    private Integer quantity;
    private String name;
    private BigDecimal price;
}