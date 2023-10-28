package com.mapstruct.api.mapper;

import com.mapstruct.api.dto.DivisionDTO;
import com.mapstruct.entity.Division;
import org.mapstruct.Mapper;

@Mapper
public interface DivisionMapper {

    DivisionDTO divisionToDivisionDTO(Division entity);

    Division divisionDTOtoDivision(DivisionDTO dto);
}
