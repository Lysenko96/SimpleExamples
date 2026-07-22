package org.example.mapstruct.innermapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);

    @Mappings({
            @Mapping(target = "status", constant = "CREATED")
    })
    EmployeeAnswer toEmployeeAnswer(Employee employee);
}
