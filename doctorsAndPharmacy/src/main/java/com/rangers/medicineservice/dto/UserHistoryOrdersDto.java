package com.rangers.medicineservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserHistoryOrdersDto {
    /*
    User.class
    */
    private UUID userId;
    private String firstname;
    private String lastname;
    /*
    Order.class
    */
    private OrderDto orderDto;
    /*
    OrderDetail.class
    */
    //medicine
    //quantity
    //sum
}
