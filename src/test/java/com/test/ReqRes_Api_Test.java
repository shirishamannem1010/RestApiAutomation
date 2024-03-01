package com.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.base.BaseClass;

import endpoints.ReqResEndPoints;
import payloads.ReqResPayload;
import payloads.ReqResRegisterPayload;
import io.qameta.allure.Epic;
import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

@Epic("Rest Assured Automation with ReqRes Url")
public class ReqRes_Api_Test extends BaseClass{
int userId;

	@Test(priority = 1)
	public void testRegisterUser() {
		test= extent.createTest("Register User in ReqRes").assignAuthor("shirishamannem")
				.assignDevice("Windows Desktop");
		ReqResRegisterPayload user = new ReqResRegisterPayload("eve.holt@reqres.in", "pistol");

	    Response response = ReqResEndPoints.registerUser(user);

	    System.out.println("Register User Response Code: " + response.getStatusCode());
	    System.out.println("Register User Response Body: " + response.getBody().asString());

	    assertEquals(response.getStatusCode(), 200);
	   
	}

	@Test(priority = 2)
	public void testLoginUser() {
		test= extent.createTest("Login User in ReqRes").assignAuthor("shirishamannem")
				.assignDevice("Windows Desktop");
		
		ReqResRegisterPayload user = new ReqResRegisterPayload("eve.holt@reqres.in", "pistol");

    Response response = ReqResEndPoints.loginUser(user);

    System.out.println("Login User Response Code: " + response.getStatusCode());
    System.out.println("Login User Response Body: " + response.getBody().asString());

    assertEquals(response.getStatusCode(), 200);
	}

	  @Test(priority = 3)
	    public void testCreateUser() {
		  test= extent.createTest("Create User in ReqRes").assignAuthor("shirishamannem")
					.assignDevice("Windows Desktop");
		  
        ReqResPayload reqres = new ReqResPayload("Shirisha", "Software Engineer");

	        Response response = ReqResEndPoints.createUser(reqres);

	        System.out.println("Create User Response Code:---------------- " + response.getStatusCode());
	        System.out.println("Create User Response Body: " + response.getBody().asString());
	        System.out.println("===================="+response);
	        System.out.println("----------------------"+response.getStatusCode());
	        
	        JsonPath jsonPath = response.jsonPath();
	        userId = jsonPath.getInt("id");


	        assertEquals(response.getStatusCode(), 201);
	  }
	    @Test(priority = 4)
	    public void testGetSingleUser() {
	    	test= extent.createTest("Get Single User Details in ReqRes").assignAuthor("shirishamannem")
					.assignDevice("Windows Desktop");
	    	
	        Response response = ReqResEndPoints.getSingleUser();

	        System.out.println("Get Single User Response Code: " + response.getStatusCode());
	        System.out.println("Get Single User Response Body: " + response.getBody().asString());

	        assertEquals(response.getStatusCode(), 200);
	    }
	    
	    @Test(priority = 5)
	    public void testUpdateUser() {
	    	test= extent.createTest("Update User Details in ReqRes").assignAuthor("shirishamannem")
					.assignDevice("Windows Desktop");
	    	
	        ReqResPayload updatereqres  = new ReqResPayload("Shirisha Mannem", "QA engineer");

	        Response response = ReqResEndPoints.updateUser(userId, updatereqres);

	        System.out.println("Update User Response Code: " + response.getStatusCode());
	        System.out.println("Update User Response Body: " + response.getBody().asString());

	        assertEquals(response.getStatusCode(), 200);
	    }

	    @Test(priority = 6)
	    public void testDeleteUser() {

	    	test= extent.createTest("Delete User Details in ReqRes").assignAuthor("shirishamannem")
					.assignDevice("Windows Desktop");
	    	
	        Response response = ReqResEndPoints.deleteUser(userId);

	        System.out.println("Delete User Response Code: " + response.getStatusCode());
	        System.out.println("Delete User Response Body: " + response.getBody().asString());

	        assertEquals(response.getStatusCode(), 204);

	    }
    
}
