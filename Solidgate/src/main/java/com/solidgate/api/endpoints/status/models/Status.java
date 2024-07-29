package com.solidgate.api.endpoints.status.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {

    @JsonProperty("order")
    private Order order;

    @JsonProperty("pay_form")
    private JsonNode pay_form;

    @JsonProperty("payment_adviser")
    private JsonNode payment_adviser;

    @JsonProperty("order_metadata")
    private JsonNode order_metadata;

    @JsonProperty("redirect_url")
    private String redirect_url;

    @JsonProperty("device_info")
    private JsonNode device_info;

    @JsonProperty("transactions")
    private JsonNode transactions;

    @JsonProperty("three_ds")
    private JsonNode three_ds;

    @JsonProperty("routing")
    private JsonNode routing;
}