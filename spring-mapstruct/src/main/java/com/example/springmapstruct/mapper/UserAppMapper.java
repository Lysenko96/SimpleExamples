package com.example.springmapstruct.mapper;

import com.example.springmapstruct.dto.UserAppDto;
import com.example.springmapstruct.entity.UserApp;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserAppMapper {

    UserAppDto toUserAppDto(UserApp userApp);
}
