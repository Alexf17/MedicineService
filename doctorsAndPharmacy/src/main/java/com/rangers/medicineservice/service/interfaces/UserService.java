package com.rangers.medicineservice.service.interfaces;

import com.rangers.medicineservice.dto.*;
import java.util.List;

public interface UserService {
    UserAfterRegistrationDto createUser(UserRegistrationDto userRegistrationDto);
    UserInfoDto getUserById(String id);
    String getUserIdByChatId(String chatId);
    UserInfoDto updateUser(UserInfoDto userInfoDto);
    List<OrderDto> getUserHistoryOrders(String id);
    UserHistorySchedulesDto getUserHistorySchedules(String id);
    UserHistoryPrescriptionsDto getUserHistoryPrescriptions(String id);
}
