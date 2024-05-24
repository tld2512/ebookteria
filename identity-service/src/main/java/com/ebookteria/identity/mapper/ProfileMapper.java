package com.ebookteria.identity.mapper;

import com.ebookteria.identity.dto.request.ProfileCreationRequest;
import com.ebookteria.identity.dto.request.UserCreationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);
}
