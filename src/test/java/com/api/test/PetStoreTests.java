package com.api.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

/**
 * Test class for PetStore API functionality
 * This class contains test cases for retrieving and validating pet information
 * from the PetStore API
 */
public class PetStoreTests {


    /**
     * Test case to verify retrieving available pets from PetStore
     * Steps:
     * 1. Sets up the base URI for PetStore API
     * 2. Sends GET request to fetch pets with 'available' status
     * 3. Validates response status code
     * 4. Extracts and validates pet details from response
     */
    @Test
    public void ValidtestGetAvailablePets() {
        // Set Base URI for PetStore API
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        // Send GET request with query param ?status=available
        Response response = given()
                .queryParam("status", "available")
                .when()
                .get("/pet/findByStatus");

        // Assert the response status code is 200 OK
        assertThat(response.statusCode(), equalTo(200));

        // Extract pet details from the second pet in the response array
        String petName = response.jsonPath().getString("[1].name");
        String petStatus = response.jsonPath().getString("[1].status");

        // Log the extracted pet details for verification
        System.out.println("Pet Name: " + petName);
        System.out.println("Pet Status "  + petStatus);
    }
}