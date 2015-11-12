package org.springframework.social.daum.api;

public class DaumProfile {
    private String userId;

    private String imageUrl;

    private String daumId;

    private String daumName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDaumId() {
        return daumId;
    }

    public void setDaumId(String daumId) {
        this.daumId = daumId;
    }

    public String getDaumName() {
        return daumName;
    }

    public void setDaumName(String daumName) {
        this.daumName = daumName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProfileUrl() {
        return "";
    }

}
