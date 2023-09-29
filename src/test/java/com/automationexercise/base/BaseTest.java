package com.automationexercise.base;

/**
 * @author Ragul
 * 
 */

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.automationexercise.utilities.ReadProperties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseTest {

	Properties property;
	File file;
	FileInputStream fileinput;

	PrintStream loghere;
	RequestSpecification reqspec;
	ResponseSpecification resspec;
	ReadProperties read = new ReadProperties();

	/**
	 * 
	 * @return requestspecifcation object
	 */
	public RequestSpecification reqBuild() {

		try {
			loghere = new PrintStream(new FileOutputStream("logging.txt"));
			reqspec = new RequestSpecBuilder().setRelaxedHTTPSValidation().setBaseUri(read.getbaseUri()).setContentType(ContentType.JSON)
					.addFilter(RequestLoggingFilter.logRequestTo(loghere))
					.addFilter(ResponseLoggingFilter.logResponseTo(loghere)).build();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reqspec;
	}

	/**
	 * 
	 * @param statuscode
	 * @return responsespecification object
	 */
	public ResponseSpecification responeBuilder(int statuscode) {

		resspec = new ResponseSpecBuilder().expectStatusCode(statuscode).build();

		return resspec;
	}

}
