package com.test;

import org.testng.annotations.Test;

import com.base.Breaking_Base;
import endpoints.BreakingBadEndPoints;
import io.restassured.response.Response;

public class BreakingBadAPITest extends Breaking_Base {
	 int breakingId;

	    @Test(priority = 1)
	    public void testCreateCharacter() {
	        test = extent.createTest("Create Character").assignAuthor("shirishamannem").assignDevice("Windows Desktop");

	        Response response = BreakingBadEndPoints.createCharacter(breaking);
	        String contentType = response.getContentType();
	        System.out.println("Content Type: " + contentType);

	        if (contentType != null) {
	            if (contentType.equalsIgnoreCase("application/json")) {
	                // Parse JSON response
	                breakingId = response.then().log().all().extract().path("id");
	            } else {
	                // Handle non-JSON response
	                System.out.println("Non-JSON response received. Content Type: " + contentType);
	                System.out.println("Response Body: " + response.getBody().asString());
	                // Log the response for analysis or fail the test
	                // Additional handling logic here
	            }
	        } else {
	            // Handle the case where Content-Type is not present in the response header
	            System.out.println("Content-Type header not present in the response");
	            // Additional handling logic here
	        }
	        System.out.println(" ---------------------------" + response.getStatusCode());
	    }
	
	@Test(priority = 2)
	public void testGetBookingId() {
		test=extent.createTest("Get Booking Ids").assignAuthor("shirishamannem")
				.assignDevice("Windows Desktop");
		Response response= BreakingBadEndPoints.getCharactersById(breakingId);
		response.then().log().all();
		
		System.out.println("response========================="+response);
		
//		assertEquals(response.statusCode(), 200);
	} 
}

