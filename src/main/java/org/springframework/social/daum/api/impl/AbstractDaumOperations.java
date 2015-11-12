package org.springframework.social.daum.api.impl;

import org.springframework.social.MissingAuthorizationException;

public class AbstractDaumOperations {
    private final boolean isAuthorized;

    public AbstractDaumOperations(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    protected void requireAuthorization() {
        if (!isAuthorized) {
            throw new MissingAuthorizationException("daum");
        }
    }
}
