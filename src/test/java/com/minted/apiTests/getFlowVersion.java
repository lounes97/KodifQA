package com.minted.apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class getFlowVersion {
    String kodifBaseURL = "http://api.kodif.io:80";

    @Test
    public void getFlowVersion() {
        Response response = RestAssured.post(kodifBaseURL + "/api/v1/crud/company/1/flow/59d8efa0-4ef8-432e-af3e-3379b6f97f4a/version/3e216147-06c8-4c56-9bca-b2b4b91228fb");
        //status code
        int statusCode = response.statusCode();
        System.out.println("statusCode = " + statusCode);
        Assertions.assertEquals(401,statusCode );
        response.getStatusCode();
        //content type
        String contentType = response.contentType();
        System.out.println("contentType = " + contentType);
        Assertions.assertEquals("application/json", contentType);

        //print body
        System.out.println("****************************************");
        System.out.println(response.asString());

        System.out.println("**********prettyPrint************");
        System.out.println(response.prettyPrint());


    }
}
