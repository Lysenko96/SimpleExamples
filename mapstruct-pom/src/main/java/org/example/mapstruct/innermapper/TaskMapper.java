package org.example.mapstruct.innermapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = EmployeeMapper.class)
public interface TaskMapper {

    TaskMapper mapper = Mappers.getMapper(TaskMapper.class);

    @Mappings({
            @Mapping(target = "date", expression = "java(java.time.LocalDateTime.now())")
    })
    TaskAnswer toTaskAnswer(Task task);

}
