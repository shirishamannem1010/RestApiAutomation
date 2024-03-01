package com.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import payloads.Booking;
import payloads.BookingDates;
import payloads.BreakingBad;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

public class Breaking_Base {
	private static final Logger logger = LogManager.getLogger(BaseClass.class.getName());
	public static ExtentReports extent;
	public BreakingBad breaking;
	public Faker faker;
	public static ExtentTest test;
	ObjectMapper objectMapper = new ObjectMapper();
	String json;
	@BeforeTest
	public void setUp() {
		logger.info("Report Setup in each Test");
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/Extentreport.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("MyReport");
		spark.config().setReportName("Test Report");
		spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}

	@BeforeClass
	public void setupData() throws JsonProcessingException {
		 RestAssured.defaultParser = Parser.JSON;
		faker = new Faker();
		breaking = new BreakingBad();
		breaking.setName(faker.name().username());
		breaking.setChemistryProfessor(faker.job().position());
		breaking.setSuspect(faker.bool().bool());
		
		logger.info(breaking);
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		logger.info("Report Result in each Test");
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
			test.log(Status.FAIL, "Test Case Failed");
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Passed Sucessfully");
		} else {
			test.log(Status.SKIP, result.getTestName());
		}
	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}
}
