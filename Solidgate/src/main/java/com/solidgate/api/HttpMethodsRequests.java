package com.solidgate.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.apache.hc.core5.http.HttpStatus;
import org.assertj.core.api.Assertions;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public abstract class HttpMethodsRequests {

    public static Response get(RequestSpecBuilder specBuilder) {
        Response response = given().spec(specBuilder.build()).get();
        return validateResponseCode(response);
    }

    private static Response validateResponseCode(Response response, int statusCode) {
        try {
            Assertions.assertThat(response.statusCode()).as("Status code").isEqualTo(statusCode);
        } catch (AssertionError e) {
            String oldMessage = e.getMessage();
            String newMessage = format("%s \n Response: %s \n", oldMessage, response.body().asString());
            throw new AssertionError(newMessage);
        }
        return response;
    }

    private static Response validateResponseCode(Response response) {
        return validateResponseCode(response, HttpStatus.SC_OK);
    }
}