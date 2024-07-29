package com.solidgate.api.endpoints.status;

import com.solidgate.api.APIBase;
import com.solidgate.api.endpoints.status.models.Status;
import io.restassured.builder.RequestSpecBuilder;

import static com.solidgate.api.HttpMethodsRequests.get;
import static java.lang.String.format;

public class StatusRequests extends APIBase {

    private static final String ENDPOINT = format("/status/%s", CONFIG.onetimeEndpoint());

    private RequestSpecBuilder requestSpecBuilder() {
        return basicRequestSpecBuilder().setBasePath(ENDPOINT);
    }

    public Status getStatus() {
        var response = get(requestSpecBuilder());
        return response.as(Status.class);
    }
}