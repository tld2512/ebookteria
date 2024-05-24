package com.ebookteria.profile.mapper;

import com.ebookteria.profile.dto.request.ProfileCreationRequest;
import com.ebookteria.profile.dto.response.UserProfileResponse;
import com.ebookteria.profile.entity.UserProfile;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class UserProfileMapperImpl implements UserProfileMapper {

    @Override
    public UserProfile toUserProfile(ProfileCreationRequest request) {
        if ( request == null ) {
            return null;
        }

        UserProfile.UserProfileBuilder userProfile = UserProfile.builder();

        userProfile.userId( request.getUserId() );
        userProfile.firstName( request.getFirstName() );
        userProfile.lastName( request.getLastName() );
        userProfile.dob( request.getDob() );
        userProfile.city( request.getCity() );

        return userProfile.build();
    }

    @Override
    public UserProfileResponse toUserProfileResponse(UserProfile userProfile) {
        if ( userProfile == null ) {
            return null;
        }

        UserProfileResponse.UserProfileResponseBuilder userProfileResponse = UserProfileResponse.builder();

        userProfileResponse.id( userProfile.getId() );
        userProfileResponse.firstName( userProfile.getFirstName() );
        userProfileResponse.lastName( userProfile.getLastName() );
        userProfileResponse.dob( userProfile.getDob() );
        userProfileResponse.city( userProfile.getCity() );

        return userProfileResponse.build();
    }
}
