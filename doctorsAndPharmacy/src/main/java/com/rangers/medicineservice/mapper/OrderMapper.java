package com.rangers.medicineservice.mapper;

import com.rangers.medicineservice.dto.OrderDto;
import com.rangers.medicineservice.dto.UserHistoryOrdersDto;
import com.rangers.medicineservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.sql.Timestamp;
import java.util.List;

@Mapper(componentModel = "spring", imports = Timestamp.class)
public interface OrderMapper {
    OrderDto toDto(Order order);

//    @Mappings({
//            @Mapping(target = "firstName", source = "employeeRegistrationDto.firstName"),
//            @Mapping(target = "lastName", source = "employeeRegistrationDto.lastName"),
//            @Mapping(target = "driver", source = "employeeRegistrationDto.driver"),
//            @Mapping(target = "working", expression = "java(true)"),
//            @Mapping(target = "createdAt", expression = "java(new Timestamp(System.currentTimeMillis()))"),
//
//            @Mapping(target = "employeeInfo.address", source = "employeeRegistrationDto.address"),
//            @Mapping(target = "employeeInfo.phone", source = "employeeRegistrationDto.phone"),
//            @Mapping(target = "employeeInfo.drivingLicenseCategory", source = "employeeRegistrationDto.drivingLicenseCategory"),
//            @Mapping(target = "employeeInfo.login", source = "employeeRegistrationDto.login"),
//            @Mapping(target = "employeeInfo.password", expression = "java(generatePassword())"),
//            @Mapping(target = "employeeInfo.createdAt", expression = "java(new Timestamp(System.currentTimeMillis()))"),
//            @Mapping(target = "employeeInfo.roles", source = "roles")
//    })
    List<UserHistoryOrdersDto> toUserHistoryOrdersDto(List<Order> orders);
}
