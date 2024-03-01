package com.test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.base.BaseClass;
import endpoints.BookEndPoint;
import utils.GenerateToken;
import com.github.javafaker.Book;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
@Epic("Rest Assured Automation")
public class RestfulBookerAPITest extends BaseClass{
	 int bookingId;
	    String token;
	@Test(priority = 1)
	public void testCreateToken() {
		test= extent.createTest("Create Token").assignAuthor("shirishamannem")
				.assignDevice("Windows Desktop");
		Response response= BookEndPoint.createToken(createToken);
		token =response.then().log().all()
		.extract()
		.path("token");
		
		assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2)
	public void testCreateBooking() {
		test=extent.createTest("Create Booking Test").assignAuthor("shirishamannem")
				.assignDevice("Windows Desktop");
		Response response= BookEndPoint.createBooking(booking);
	bookingId=	response.then().log().all()
		.extract()
		.path("bookingid");
		
		assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority = 3)
	public void testGetBookingId() {
		test=extent.createTest("Get Booking Ids").assignAuthor("shirishamannem")
				.assignDevice("Windows Desktop");
		Response response= BookEndPoint.getBookingById(bookingId);
		response.then().log().all();
		
		assertEquals(response.statusCode(), 200);
	} 
//	@Test(priority = 4)
//    public void testUpdateBookingById() {
//        test = extent.createTest("testUpdateBookingById")
//                .assignAuthor("suresh").assignDevice("Windows Desktop");
//        booking.setTotalPrice(100);
//        booking.setAdditionalNeeds("BreakFast");
//       
//        Response response = BookEndPoint.updateBookingById(bookingId, booking, token);
//        response.then().log().all();
//        
//        
//        
//        
//        assertEquals(response.getStatusCode(), 200);
//    }
	
	@Test(priority = 4)
	public void testUpdateBookingDetails() {
		test=extent.createTest("Update Booking details by id").assignAuthor("shirishamannem")
				.assignDevice("Windows Desktop");
		
		booking.setFirstname("shirisha");
		booking.setLastname("mannem");
		booking.setDepositPaid(true);
		booking.setTotalPrice(5555);
		 
		System.out.println("++++++++++++++++++++++++++++++++++"+token);
		 
		Response response= BookEndPoint.updateBookingById(bookingId, booking, token);
		response.then().log().all();
		
		assertEquals(response.getStatusCode(), 200);
	
	}
	@Test(priority = 5)
	public void testDeleteBookingId() {
		test=extent.createTest("Delete Booking details by id").assignAuthor("shirishamannem")
				.assignDevice("Windows Desktop");
		
		Response response= BookEndPoint.deleteBooking(bookingId, token);
		response.then().log().all();
		
		assertEquals(response.getStatusCode(), 201);
	}
	
}
