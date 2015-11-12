package org.springframework.social.daum.api.impl;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.daum.api.Daum;
import org.springframework.social.daum.api.ProfileOperation;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;

public class DaumTemplate extends AbstractOAuth2ApiBinding implements Daum {

    private static final Logger logger = LoggerFactory.getLogger(DaumTemplate.class);

    private ProfileOperation profileOperation;

    public DaumTemplate(String accessToken) {
        super(accessToken);
        initialize();
    }

    @Override
    public ProfileOperation profileOperation() {
        return profileOperation;
    }

    public <T> T get(URI uri, Class<T> resultType) {
        return getRestTemplate().getForObject(uri, resultType);
    }

    public <T> T post(URI uri, MultiValueMap<String, String> data, Class<T> resultType) {
        logger.debug("Kakao template post uri: " + uri.toString());
        return getRestTemplate().postForObject(uri, new LinkedMultiValueMap<>(data), resultType);
    }

    public void delete(URI uri) {
        getRestTemplate().delete(uri);
    }

    @Override
    public JsonNode fetchProfile() {
        return get(URIBuilder.fromUri(DAUM_API_URL + "user/v1/show.json").build(), JsonNode.class);
    }

    private void initialize() {
        super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
        initSubApis();
    }

    private void initSubApis() {
        profileOperation = new ProfileTemplate(this, isAuthorized());
    }


}
