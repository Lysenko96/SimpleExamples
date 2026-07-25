package com.example.springmapstruct.mapper;

import com.example.springmapstruct.dto.DemoUserAppDto;
import com.example.springmapstruct.dto.ResponseClientDto;
import com.example.springmapstruct.dto.UserAppDto;
import com.example.springmapstruct.entity.Role;
import com.example.springmapstruct.entity.UserApp;
import com.example.springmapstruct.entity.UserAppSecond;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserAppMapper {

    UserAppDto toUserAppDto(UserApp userApp);

    @Mapping(source = "roles", target = "roles", qualifiedByName = "rolesToString")
    DemoUserAppDto toDemoUserAppDto(UserApp userApp);

    @Mapping(source = "name", target = "clientName")
    @Mapping(source = "age", target = "clientAge", defaultValue = "1")
    @Mapping(source = "address", target = "clientAddress")
    @Mapping(source = "roles", target = "clientRoles")
    @Mapping(target = "response", expression = "java(java.time.LocalDateTime.now())")
    ResponseClientDto toResponseClientDto(UserApp userApp);

    @Named("rolesToString")
    default String rolesToString(List<Role> roles) {
        return roles != null && !roles.isEmpty() ? roles.stream().map(Role::name).collect(Collectors.joining(";")) : "" ;
    }


    @Mapping(source = "userApp.name", target = "clientName")
    @Mapping(source = "userAppSecond.age", target = "clientAge")
    @Mapping(source = "userApp.address", target = "clientAddress")
    @Mapping(source = "userApp.roles", target = "clientRoles")
    @Mapping(target = "userApp.response", expression = "java(java.time.LocalDateTime.now())")
    ResponseClientDto toResponseClientDto(UserApp userApp, UserAppSecond userAppSecond);


}
