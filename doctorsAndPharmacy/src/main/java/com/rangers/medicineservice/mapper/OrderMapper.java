package com.rangers.medicineservice.mapper;

import com.rangers.medicineservice.dto.OrderDto;
import com.rangers.medicineservice.dto.UserHistoryOrdersDto;
import com.rangers.medicineservice.entity.Order;
import org.mapstruct.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper(componentModel = "spring", imports = Timestamp.class)
public interface OrderMapper {
    OrderDto toDto(Order order);

    @Mappings({
            @Mapping(target = "orderId", source = "orderId"),
            @Mapping(target = "orderDate", source = "orderDate"),
            @Mapping(target = "quantity", source = "order.orderDetails.quantity"),
            @Mapping(target = "name", source = "order.orderDetails.medicine.name"),
            @Mapping(target = "price", source = "order.orderDetails.medicine.price"),
    })
    List<UserHistoryOrdersDto> toUserHistoryOrdersDto(List<Order> orders);
}
