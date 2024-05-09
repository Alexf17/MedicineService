package com.rangers.medicineservice.mapper.util;

import com.rangers.medicineservice.dto.MedicineDto;
import com.rangers.medicineservice.entity.Medicine;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface MedicineMapper {
    @Named("toDto")
    MedicineDto toDto(Medicine medicine);

    Medicine toEntity(MedicineDto medicineDto);
}
