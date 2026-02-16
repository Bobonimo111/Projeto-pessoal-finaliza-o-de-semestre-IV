package org.william.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.william.dto.users.GetUserDTO;
import org.william.dto.users.PostUserDTO;
import org.william.entity.UserEntity;

@Mapper(componentModel = "jakarta")
public interface UserMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    public UserEntity toEntity(PostUserDTO postUserDTO);

    public GetUserDTO toGetUserDto(UserEntity userEntity);
}
