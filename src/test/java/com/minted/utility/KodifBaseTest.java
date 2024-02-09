package com.minted.utility;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.reset;

public class KodifBaseTest {

    @BeforeAll
    public static void init(){


        baseURI="http://api.kodif.io:80/api/v1/account";

    }

    @AfterAll
    public static void destroy(){

        reset();

    }

}