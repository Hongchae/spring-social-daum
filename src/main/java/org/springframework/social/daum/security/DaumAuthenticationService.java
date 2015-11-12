package org.springframework.social.daum.security;

import org.springframework.social.daum.api.Daum;
import org.springframework.social.daum.connect.DaumConnectionFactory;
import org.springframework.social.security.provider.OAuth2AuthenticationService;

public class DaumAuthenticationService extends OAuth2AuthenticationService<Daum> {
    public DaumAuthenticationService(String clientId, String clientSecret) {
        super(new DaumConnectionFactory(clientId, clientSecret));
    }
}
