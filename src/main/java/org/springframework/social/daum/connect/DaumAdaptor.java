package org.springframework.social.daum.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.daum.api.DaumProfile;
import org.springframework.social.daum.api.Daum;

public class DaumAdaptor implements ApiAdapter<Daum> {

    public DaumAdaptor() {}

    @Override
    public boolean test(Daum daum) {
        try {
            daum.profileOperation().getUserId();
            return true;
        } catch(ApiException e) {
            return false;
        }
    }

    @Override
    public void setConnectionValues(Daum daum, ConnectionValues values) {
        DaumProfile profile = daum.profileOperation().getProfile();

        values.setProviderUserId(profile.getUserId());
        values.setDisplayName(profile.getDaumName());
        values.setProfileUrl(profile.getProfileUrl());
        values.setImageUrl(profile.getImageUrl());
    }

    @Override
    public UserProfile fetchUserProfile(Daum daum) {
        DaumProfile profile = daum.profileOperation().getProfile();

        return (new UserProfileBuilder()).setUsername(profile.getUserId()).build();
    }

    @Override
    public void updateStatus(Daum daum, String s) {
        // empty
    }
}
