package com.solidgate.api.endpoints.status.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    @JsonProperty("order_id")
    private String order_id;

    @JsonProperty("amount")
    private Integer amount;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("mid")
    private String mid;

    @JsonProperty("descriptor")
    private String descriptor;

    @JsonProperty("fraudulent")
    private Boolean fraudulent;

    @JsonProperty("marketing_amount")
    private Integer marketing_amount;

    @JsonProperty("marketing_currency")
    private String marketing_currency;

    @JsonProperty("processing_amount")
    private Integer processing_amount;

    @JsonProperty("processing_currency")
    private String processing_currency;

    @JsonProperty("status")
    private String status;

    @JsonProperty("refunded_amount")
    private Integer refunded_amount;

    @JsonProperty("order_description")
    private String order_description;

    @JsonProperty("traffic_source")
    private String traffic_source;

    @JsonProperty("customer_email")
    private String customer_email;
}