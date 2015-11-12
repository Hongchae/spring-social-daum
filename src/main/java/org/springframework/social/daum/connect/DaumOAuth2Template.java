package org.springframework.social.daum.connect;

import org.springframework.social.oauth2.OAuth2Template;

public class DaumOAuth2Template extends OAuth2Template {
    public DaumOAuth2Template(String clientId, String clientSecret) {
        super(clientId, clientSecret, "https://apis.daum.net/oauth2/authorize", "https://apis.daum.net/oauth2/token");
        setUseParametersForClientAuthentication(true);
    }


}