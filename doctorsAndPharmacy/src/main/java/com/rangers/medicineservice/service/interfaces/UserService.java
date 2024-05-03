package com.rangers.medicineservice.service.interfaces;

import com.rangers.medicineservice.dto.*;

public interface UserService {
    UserAfterRegistrationDto createUser(UserRegistrationDto userRegistrationDto);
    UserInfoDto getUserById(String id);
    String getUserIdByChatId(String chatId);
    UserInfoDto updateUser(UserInfoDto userInfoDto);
    UserHistoryOrdersDto getUserHistoryOrders(String id);
    UserHistorySchedulesDto getUserHistorySchedules(String id);
    UserHistoryPrescriptionsDto getUserHistoryPrescriptions(String id);
}
