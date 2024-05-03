package com.rangers.medicineservice.dto;

import lombok.Value;

@Value
public class UserAfterRegistrationDto {
    String operation = "USER CREATION";
    String status = "CREATED";
    String firstname;
    String lastname;
    String chatId;
    String creationDate;
}
