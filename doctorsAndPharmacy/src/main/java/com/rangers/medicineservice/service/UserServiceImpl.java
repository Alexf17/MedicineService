package com.rangers.medicineservice.service;

import com.rangers.medicineservice.dto.*;
import com.rangers.medicineservice.repository.UserRepository;
import com.rangers.medicineservice.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserAfterRegistrationDto createUser(UserRegistrationDto userRegistrationDto) {
        return null;
    }

    @Override
    public UserInfoDto getUserById(String id) {
        return null;
    }

    @Override
    public String getUserIdByChatId(String chatId) {
        return null;
    }

    @Override
    public UserInfoDto updateUser(UserInfoDto userInfoDto) {
        return null;
    }

    @Override
    public UserHistoryOrdersDto getUserHistoryOrders(String id) {
        return null;
    }

    @Override
    public UserHistorySchedulesDto getUserHistorySchedules(String id) {
        return null;
    }

    @Override
    public UserHistoryPrescriptionsDto getUserHistoryPrescriptions(String id) {
        return null;
    }
}
