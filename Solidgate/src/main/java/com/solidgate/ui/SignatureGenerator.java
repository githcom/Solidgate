package com.solidgate.ui;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class SignatureGenerator {

    public static String generateSignature(String publicKey, String jsonString, String secretKey) {
        String text = publicKey + jsonString + publicKey;
        byte[] hashedBytes = Hashing.hmacSha512(secretKey.getBytes())
                .hashString(text, StandardCharsets.UTF_8).toString().getBytes();
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    public static void main(String[] args) {
        String publicKey = "api_pk_d0835bcc_4d4d_4eea_a969_609a850fbbf5";
        String secretKey = "api_sk_9eaf753f_c17e_4372_a487_ece90111a794";
        String jsonString = "{\n" +
                "    \"order\": {\n" +
                "        \"order_id\": \"923bb4e6-4a5f-41ec-81fb-28eb8a157h66\",\n" +
                "        \"amount\": 1020,\n" +
                "        \"currency\": \"EUR\",\n" +
                "        \"order_description\": \"Premium package\",\n" +
                "        \"order_items\": \"item 1 x 10, item 2 x 30\",\n" +
                "        \"order_date\": \"2015-12-21 11:21:30\",\n" +
                "        \"order_number\": 9,\n" +
                "        \"type\": \"auth\",\n" +
                "        \"settle_interval\": 0,\n" +
                "        \"retry_attempt\": 3,\n" +
                "        \"force3ds\": false,\n" +
                "        \"google_pay_allowed_auth_methods\": [\n" +
                "            \"PAN_ONLY\"\n" +
                "        ],\n" +
                "        \"customer_date_of_birth\": \"1988-11-21\",\n" +
                "        \"customer_email\": \"example@example.com\",\n" +
                "        \"customer_first_name\": \"Nikola\",\n" +
                "        \"customer_last_name\": \"Tesla\",\n" +
                "        \"customer_phone\": \"+10111111111\",\n" +
                "        \"traffic_source\": \"facebook\",\n" +
                "        \"transaction_source\": \"main_menu\",\n" +
                "        \"purchase_country\": \"USA\",\n" +
                "        \"geo_country\": \"USA\",\n" +
                "        \"geo_city\": \"New Castle\",\n" +
                "        \"language\": \"pt\",\n" +
                "        \"website\": \"https://solidgate.com\",\n" +
                "        \"order_metadata\": {\n" +
                "            \"coupon_code\": \"NY2018\",\n" +
                "            \"partner_id\": \"123989\"\n" +
                "        },\n" +
                "        \"success_url\": \"http://merchant.example/success\",\n" +
                "        \"fail_url\": \"http://merchant.example/fail\"\n" +
                "    },\n" +
                "    \"page_customization\": {\n" +
                "        \"public_name\": \"Public Name\",\n" +
                "        \"order_title\": \"Order Title\",\n" +
                "        \"order_description\": \"Premium package\",\n" +
                "        \"payment_methods\": [\n" +
                "            \"paypal\"\n" +
                "        ],\n" +
                "        \"button_font_color\": \"#FFFFFF\",\n" +
                "        \"button_color\": \"#00816A\",\n" +
                "        \"font_name\": \"Open Sans\",\n" +
                "        \"is_cardholder_visible\": true,\n" +
                "        \"terms_url\": \"https://solidgate.com/terms\",\n" +
                "        \"back_url\": \"https://solidgate.com\"\n" +
                "    }\n" +
                "}";
        String signature = generateSignature(publicKey, jsonString, secretKey);
        System.out.println(signature);
    }
}