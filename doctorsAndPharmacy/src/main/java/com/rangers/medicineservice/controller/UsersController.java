package com.rangers.medicineservice.controller;

import com.rangers.medicineservice.dto.UserHistoryOrdersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsersController {

    //private final UsersService usersService;
    @GetMapping("/{id}")
    public UserHistoryOrdersDto getUserHistoryOrders(@PathVariable("id") String id){
        return null;

    }

}
