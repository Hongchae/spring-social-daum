package org.springframework.social.daum.api.impl;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.social.daum.api.DaumProfile;
import org.springframework.social.daum.api.DaumApi;
import org.springframework.social.daum.api.ProfileOperation;

public class ProfileTemplate extends AbstractDaumOperations implements ProfileOperation {

    private final DaumApi daumApi;

    public ProfileTemplate(DaumApi daumApi, boolean isAuthorizedForUser) {
        super(isAuthorizedForUser);
        this.daumApi = daumApi;
    }

    @Override
    public String getUserId() {
        requireAuthorization();
        return daumApi.fetchProfile().get("result").get("userid").asText();
    }

    @Override
    public DaumProfile getProfile() {
        requireAuthorization();
        JsonNode profileNode = daumApi.fetchProfile().get("result");

        final DaumProfile profile = new DaumProfile();
        profile.setUserId(profileNode.get("userid").asText());
        profile.setDaumName(profileNode.get("nickname").asText());
        profile.setImageUrl(profileNode.get("imagePath").asText());
        return profile;
    }
}
