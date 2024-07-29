package com.solidgate.api.endpoints.details;

import com.solidgate.api.APIBase;
import com.solidgate.api.endpoints.details.models.Details;
import io.restassured.builder.RequestSpecBuilder;

import static com.solidgate.api.HttpMethodsRequests.get;
import static java.lang.String.format;

public class DetailsRequests extends APIBase {

    private static final String ENDPOINT = format("/details/%s", CONFIG.onetimeEndpoint());

    private RequestSpecBuilder requestSpecBuilder() {
        return basicRequestSpecBuilder().setBasePath(ENDPOINT);
    }

    public Details getDetails() {
        var response = get(requestSpecBuilder());
        return response.as(Details.class);
    }
}