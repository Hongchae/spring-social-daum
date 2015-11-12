package org.springframework.social.daum.api;

import org.springframework.social.ApiBinding;

public interface Daum extends DaumApi, ApiBinding{
    ProfileOperation profileOperation();
}
