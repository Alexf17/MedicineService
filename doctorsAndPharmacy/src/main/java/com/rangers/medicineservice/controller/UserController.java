package com.rangers.medicineservice.controller;

import com.rangers.medicineservice.dto.*;
import com.rangers.medicineservice.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/registration")
    public UserAfterRegistrationDto createUser (@RequestBody UserRegistrationDto userRegistrationDto){
        return userService.createUser(userRegistrationDto);
    }

    @GetMapping("/{id}")
    public UserInfoDto getUserById(@PathVariable("id") String id){
        return userService.getUserById(id);
    }

    @GetMapping("/chatId/{chatId}")
    public String getUserIdByChatId(@PathVariable("chatId") String chatId){
        return userService.getUserIdByChatId(chatId);
    }

    @GetMapping("/update/{id}")
    public UserInfoDto updateUser(@RequestBody UserInfoDto userInfoDto){
        return userService.updateUser(userInfoDto);
    }

    @GetMapping("/history/orders/{id}")
    public UserHistoryOrdersDto getUserHistoryOrders(@PathVariable("id") String id){
        return userService.getUserHistoryOrders(id);
    }

    @GetMapping("/history/schedules/{id}")
    public UserHistorySchedulesDto getUserHistorySchedules(@PathVariable("id") String id){
        return userService.getUserHistorySchedules(id);
    }

    @GetMapping("/history/prescriptions/{id}")
    public UserHistoryPrescriptionsDto getUserHistoryPrescriptions(@PathVariable("id") String id){
        return userService.getUserHistoryPrescriptions(id);
    }
}
