package com.solidgate.api.endpoints.status;

import com.solidgate.api.APIBase;
import com.solidgate.api.endpoints.status.models.Status;
import com.solidgate.ui.config.TestConfig;
import io.restassured.builder.RequestSpecBuilder;
import org.aeonbits.owner.ConfigCache;

import static com.solidgate.api.HttpMethodsRequests.get;

public class StatusRequests extends APIBase {

    private static final String ENDPOINT = String.format("/status/%s",
            ConfigCache.getOrCreate(TestConfig.class).onetimeEndpoint());

    private RequestSpecBuilder requestSpecBuilder() {
        return basicRequestSpecBuilder().setBasePath(ENDPOINT);
    }

    public Status getStatus() {
        var response = get(requestSpecBuilder());
        return response.as(Status.class);
    }
}