package com.example.springmapstruct.mapper;

import com.example.springmapstruct.dto.ResponseClientDto;
import com.example.springmapstruct.dto.UserAppDto;
import com.example.springmapstruct.entity.UserApp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserAppMapper {

    UserAppDto toUserAppDto(UserApp userApp);

    @Mapping(source = "name", target = "clientName")
    @Mapping(source = "age", target = "clientAge", defaultValue = "1")
    @Mapping(source = "address", target = "clientAddress")
    @Mapping(source = "roles", target = "clientRoles")
    @Mapping(target = "response", expression = "java(java.time.LocalDateTime.now())")
    ResponseClientDto toResponseClientDto(UserApp userApp);
}
