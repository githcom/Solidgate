package com.solidgate.api.endpoints.details;

import com.solidgate.api.APIBase;
import com.solidgate.api.endpoints.details.models.Details;
import com.solidgate.ui.config.TestConfig;
import io.restassured.builder.RequestSpecBuilder;
import org.aeonbits.owner.ConfigCache;

import static com.solidgate.api.HttpMethodsRequests.get;

public class DetailsRequests extends APIBase {

    private static final String ENDPOINT = String.format("/details/%s",
            ConfigCache.getOrCreate(TestConfig.class).onetimeEndpoint());

    private RequestSpecBuilder requestSpecBuilder() {
        return basicRequestSpecBuilder().setBasePath(ENDPOINT);
    }

    public Details getDetails() {
        var response = get(requestSpecBuilder());
        return response.as(Details.class);
    }
}