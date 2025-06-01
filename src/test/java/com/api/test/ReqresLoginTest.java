package com.api.test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

/**
 * Test class for Reqres API authentication and user retrieval
 * Contains test cases for login functionality and user data retrieval
 */
public class ReqresLoginTest {
    
    /**
     * Test case to verify user authentication and data retrieval
     * Steps:
     * 1. Performs login to obtain authentication token
     * 2. Uses the token to retrieve user information
     * 3. Validates the response and user data
     */
    @Test
    public void getUserUsingToken() {
        // Set base URI for Reqres API
        RestAssured.baseURI = "https://reqres.in";

        // Login payload with test credentials
        String loginPayload = """
                    {
                        "email": "eve.holt@reqres.in",
                        "password": "cityslicka"
                    }
                """;

        // Step 1: Login to get authentication token
        String token = given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(loginPayload)
                .when()
                .post("/api/login")
                .then()
                .statusCode(200)
                .extract()
                .path("token");

        // Log the obtained token
        System.out.println("✅ Token: " + token);

        // Step 2: Use token to retrieve user information
        given()
                .header("x-api-key", "reqres-free-v1")
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/api/users/2")
                .then()
                .statusCode(200)
                .log().all()
                .body("data.id", equalTo(2))
                .body("data.email", containsString("@reqres.in"));
    }
}

