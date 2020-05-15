package webservices.training.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


public class RestAssuredTests {

    @BeforeTest
    public void initTest() {
        io.restassured.RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void checkStatusCode() {
        Response response = io.restassured.RestAssured.when()
                .get("/users")
                .andReturn();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void checkResponseHeader() {
        Response reponse = io.restassured.RestAssured.when()
                .get("/users")
                .andReturn();

        String rpContentTypeHeader = reponse.getHeader("Content-Type");
        Assert.assertEquals(rpContentTypeHeader, "application/json; charset=utf-8");
    }

    @Test
    public void checkResponseBody() {
        Response reponse = io.restassured.RestAssured.when()
                .get("/users")

                .andReturn();
        ResponseBody<?> responseBody = reponse.getBody();
        Object[] posts = responseBody.as(Object[].class);
        Assert.assertEquals(posts.length, 10);

    }

}
