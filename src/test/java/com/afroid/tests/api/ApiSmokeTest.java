package com.afroid.tests.api;

import com.afroid.automation.api.ApiClient;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiSmokeTest {

    @Test
    void getPost_one_returns200AndCorrectId() {
        ApiClient apiClient = new ApiClient("https://jsonplaceholder.typicode.com");

        Response response = apiClient.get("/posts/1");

        // Basic assertions
        assertEquals(200, response.statusCode(), "Expected HTTP 200 from /posts/1");
        assertEquals(1, response.jsonPath().getInt("id"), "Expected id=1 in response");
    }
}
