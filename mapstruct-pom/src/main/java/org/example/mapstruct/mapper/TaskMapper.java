package org.example.mapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

    TaskMapper mapper = Mappers.getMapper(TaskMapper.class);

    @Mappings({
            @Mapping(target = "date", expression = "java(java.time.LocalDateTime.now())"),
            @Mapping(target = "employeeName", source = "employee", qualifiedByName = "employeeGetName"),
            @Mapping(target = "number", ignore = true)
    })
    TaskAnswer toTaskAnswer(Task task);

    @Named("employeeGetName")
    default String employeeGetName(Employee employee){
        return employee.getName();
    }
}
