package com.ebookteria.profile.mapper;

import com.ebookteria.profile.dto.request.ProfileCreationRequest;
import com.ebookteria.profile.dto.response.UserProfileResponse;
import com.ebookteria.profile.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileResponse(UserProfile userProfile);
}
