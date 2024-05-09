package com.rangers.medicineservice.mapper;

import com.rangers.medicineservice.dto.CartItemBeforeCreationDto;
import com.rangers.medicineservice.dto.CartItemToOrderDetailDto;
import com.rangers.medicineservice.dto.CreatedCartItemDto;
import com.rangers.medicineservice.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", uses = MedicineMapper.class,
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CartItemMapper {

    CreatedCartItemDto toDto(CartItem cartItem);

    @Mapping(target = "cartItemId", ignore = true)
    CartItem toEntity(CartItemBeforeCreationDto cartItemDto);

    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "medicine", source = "medicine", qualifiedByName = "toDto")
    @Mapping(target = "user", source = "user")
    CartItemToOrderDetailDto toOrderDetailDto(CartItem cartItem);
}

