package com.solidgate.api;

import com.solidgate.ui.config.TestConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigCache;

public abstract class APIBase {

    protected TestConfig config = ConfigCache.getOrCreate(TestConfig.class);
    private final String BASE_URI = String.format("%s%s", config.hostUrl(), config.apiPath());

    public RequestSpecBuilder basicRequestSpecBuilder() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ErrorLoggingFilter())
                .setRelaxedHTTPSValidation()
                .setBaseUri(BASE_URI)
                .addHeader("Content-Type", ContentType.JSON.toString());
    }
}