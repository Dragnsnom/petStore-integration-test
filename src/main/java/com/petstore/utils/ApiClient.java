package com.petstore.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.petstore.config.Config.getBaseUrl;

public class ApiClient {
    private static final String BASE_URL = getBaseUrl();

    public static Response get(String endpoint) {
        return given()
                .when()
                .get(BASE_URL + endpoint);
    }

    public static Response post(String endpoint, Object body) {
        return given()
                .body(body)
                .when()
                .post(BASE_URL + endpoint);
    }

    public static Response put(String endpoint, Object body) {
        return given()
                .body(body)
                .when()
                .put(BASE_URL + endpoint);
    }

    public static Response delete(String endpoint) {
        return given()
                .when()
                .delete(BASE_URL + endpoint);
    }

    private static RequestSpecification given() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }
}