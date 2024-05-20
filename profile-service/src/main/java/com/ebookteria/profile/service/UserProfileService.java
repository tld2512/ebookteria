package com.ebookteria.profile.service;

import com.ebookteria.profile.dto.request.ProfileCreationRequest;
import com.ebookteria.profile.dto.response.UserProfileResponse;
import com.ebookteria.profile.entity.UserProfile;
import com.ebookteria.profile.mapper.UserProfileMapper;
import com.ebookteria.profile.repository.UserProfileRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileService {
    UserProfileRepository userProfileRepository;
    UserProfileMapper  userProfileMapper;

    public UserProfileResponse createProfile(ProfileCreationRequest request) {
        UserProfile  userProfile = userProfileMapper.toUserProfile(request);
        userProfile = userProfileRepository.save(userProfile);

        return userProfileMapper.toUserProfileResponse(userProfile);
    }

    public UserProfileResponse getProfile(String id) {
        UserProfile userProfile = userProfileRepository.findById(id).orElseThrow((() -> new RuntimeException("Profile not found")));

        return userProfileMapper.toUserProfileResponse(userProfile);
    }

    public List<UserProfileResponse> getAllProfiles() {
        var userProfiles = userProfileRepository.findAll();
        return userProfiles.stream().map(userProfileMapper::toUserProfileResponse).toList();
    }

}
