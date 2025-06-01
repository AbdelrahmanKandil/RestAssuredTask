package com.api.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

/**
 * Test class for Pet Creation functionality in PetStore API
 * This class contains test cases for creating new pets in the PetStore system
 */
public class CreatePetTest {

    /**
     * Test case to verify the creation of a new pet
     * Steps:
     * 1. Sets up the base URI for PetStore API
     * 2. Prepares the JSON payload for pet creation
     * 3. Sends POST request to create pet
     * 4. Validates the response status and pet details
     */
    @Test
    public void testCreatePet() {
        // Set Base URI for PetStore API
        baseURI = "https://petstore.swagger.io/v2";

        // JSON body for creating a new pet with required fields
        String body = """
                {
                                  "id": 0,
                                  "category": {
                                    "id": 0,
                                    "name": "string"
                                  },
                                  "name": "Sumerge pets",
                                  "photoUrls": [
                                    "string"
                                  ],
                                  "tags": [
                                    {
                                      "id": 0,
                                      "name": "string"
                                    }
                                  ],
                                  "status": "available"
                                }
""";

        // Send POST request with JSON body to create pet
        var response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/pet");

        // Log response details for debugging
        System.out.println(response.getStatusLine());
        System.out.println(response.getBody().asPrettyString());

        // Assert that status code is 200 (created)
        assertThat(response.statusCode(), is(200));

        // Assert that the returned pet name matches the created pet
        assertThat(response.jsonPath().getString("name"), equalTo("Sumerge pets"));

        // Print confirmation message
        System.out.println("Pet Created: " + response.jsonPath().getString("name"));
    }
}
