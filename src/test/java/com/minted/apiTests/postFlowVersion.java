package com.minted.apiTests;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class postFlowVersion {
    String kodifBaseURL = "http://api.kodif.io:80";
    @Test
    public void postFlowVersionAsString() {
        String requestBody = "{\n" +
                "    \"timestamp\": \"2023-10-18T06:55:18.419+00:00\",\n" +
                "    \"status\": 401,\n" +
                "    \"error\": \"Unauthorized\",\n" +
                "    \"message\": \"Full authentication is required to access this resource\",\n" +
                "    \"path\": \"/api/v1/crud/company/1/flow/59d8efa0-4ef8-432e-af3e-3379b6f97f4a/version\"\n" +
                "}";

        JsonPath jsonPath = given().accept(ContentType.JSON)//I need request in json
                .contentType(ContentType.JSON)//I am sending data in json
                .body(requestBody).
                when().post("/api/v1/crud/company/1/flow/59d8efa0-4ef8-432e-af3e-3379b6f97f4a/version").
                then()
                .statusCode(401)
                .contentType("application/json")
                .extract().jsonPath();

        String expectedMsg = "Full authentication is required to access this resource";
        Assertions.assertEquals("2023-10-18T06:55:18.419+00:00",jsonPath.getLong("timestamp"));
        Assertions.assertEquals("401", jsonPath.getInt("status"));
     Assertions.assertEquals("error", jsonPath.getString("Unauthorized"));
        Assertions.assertEquals(expectedMsg,jsonPath.getString("message"));
        Assertions.assertEquals("/api/v1/crud/company/1/flow/59d8efa0-4ef8-432e-af3e-3379b6f97f4a/version",jsonPath.getFloat("path"));
        

    }
}
