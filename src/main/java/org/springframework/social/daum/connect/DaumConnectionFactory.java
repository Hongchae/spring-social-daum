package org.springframework.social.daum.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.daum.api.Daum;

public class DaumConnectionFactory extends OAuth2ConnectionFactory<Daum> {
    public DaumConnectionFactory(String clientId, String clientSecret) {
        super("daum", new DaumServiceProvider(clientId, clientSecret), new DaumAdaptor());
    }

}