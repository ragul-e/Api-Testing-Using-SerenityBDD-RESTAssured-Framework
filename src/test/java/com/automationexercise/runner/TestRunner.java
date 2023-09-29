package com.automationexercise.runner;

/**
 * @author Ragul
 * 
 */
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/addproducts.feature",
		glue = "com.automationexercise.stepdef",
		tags = "@getproducts or @Addproducts or @getBrandlist or @putBrandlist or @searchproduct or @searchproductwithoutparam or @verifyLoginwithValidCredentials or @verifyLoginwithoutEmailCredentials or @deletetoverifylogin or @loginwithinvaliddetails or @createuser or @DeletUserAccount or @updateaccount or @getuserdetail"
		        
		)
public class TestRunner {
	
}
