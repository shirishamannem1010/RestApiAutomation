package com.test;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Then;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;

import org.testng.AssertJUnit;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.when;
import java.util.HashMap;
public class TestExample {

	@Test
	public void testOne() {
	Response response=RestAssured.get("https://reqres.in/api/users?page=2");
	
	
	System.out.println("time : "+response.getTime());
	System.out.println("body : "+response.getBody().asString());
	System.out.println("status line : "+ response.getStatusLine());
	System.out.println("header : "+ response.getHeader("content-type"));
	
	int statusCode = response.getStatusCode();
	AssertJUnit.assertEquals(statusCode, 200);
	System.out.println("status code : "+response.getStatusCode());
	}
	
	@Test
	public void getUsers(){
		RestAssured.baseURI = "https://reqres.in/api";
        given().get("/users?page=2")
        .then()
            .statusCode(200) 
            .log().all(); 
        
        System.out.println("======================");
        
        System.out.println("--------------------"+given().get("/users?page=2")
        .then()
            .statusCode(200).body("data[1].id", equalTo(8)).log().all());
	}
	
	@Test
	public void createUser() {
		
        EncoderConfig encoderConfig = EncoderConfig.encoderConfig().defaultContentCharset("UTF-8");

        RestAssuredConfig restAssuredConfig = RestAssured.config()
                .encoderConfig(encoderConfig);

        RestAssured.given()
                .config(restAssuredConfig)
                .body("{\"name\":\"shirisha\",\"job\":\"software engineer\"}")
                .when()
                .post("/your-api-endpoint")
                .prettyPrint();
               
	}

}
