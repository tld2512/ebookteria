package com.ebookteria.identity.mapper;

import com.ebookteria.identity.dto.request.UserCreationRequest;
import com.ebookteria.identity.dto.request.UserUpdateRequest;
import com.ebookteria.identity.dto.response.UserResponse;
import com.ebookteria.identity.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
