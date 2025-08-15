package com.petstore;

import com.petstore.utils.TestDataGenerator;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    protected static TestDataGenerator testDataGenerator = new TestDataGenerator();

    @BeforeAll
    public static void setUp() {
        RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL), new ResponseLoggingFilter(LogDetail.ALL));
    }
}