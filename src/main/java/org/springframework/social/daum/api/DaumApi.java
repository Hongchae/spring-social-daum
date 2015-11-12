package org.springframework.social.daum.api;

import com.fasterxml.jackson.databind.JsonNode;

public interface DaumApi {
    String DAUM_API_URL = "https://apis.daum.net/";

    JsonNode fetchProfile();
}
