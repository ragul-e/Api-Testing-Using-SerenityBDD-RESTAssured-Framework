package com.automationexercise.stepdef;

/**
 * @author Ragul
 * 
 */
import org.junit.After;

import com.automationexercise.base.BaseTest;
import com.automationexercise.steps.GetAllProductLis;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class StepDefAutomationExercise {

	BaseTest base = new BaseTest();

	@Steps
	GetAllProductLis allProductLis;

	@Before
	@Given("User launch application")
	@Step
	public void user_launch_application() {
		base.reqBuild();
	}

	@When("user creates product")
	@Step
	public void user_creates_product() {
		allProductLis.addProduct();
	}

	@When("user gets product")
	@Step
	public void user_gets_product() {
		allProductLis.getAllProducts();
	}

	@When("user get brands")
	@Step
	public void user_get_brands() {
		allProductLis.getAllBrandList();
	}

	@When("user create brands")
	@Step
	public void user_create_brands() {
		allProductLis.putAllBrandList();
	}

	@When("user search products")
	@Step
	public void user_search_products() {
		allProductLis.searchProduct();
	}

	@When("user search products without value")
	@Step
	public void user_search_products_without_value() {
		allProductLis.searchProductWithoutParam();
	}

	@When("user login with valid credentials")
	public void user_login_with_valid_credentials() {
		allProductLis.verifyLogin();
	}

	@When("user login without valid credentials")
	public void user_login_without_valid_credentials() {
		allProductLis.verifyLoginWithoutEmailParameter();
	}

	@When("user delete the login")
	public void user_delete_the_login() {
		allProductLis.deleteToVerifyLogin();
	}

	@When("login with invalid credentials")
	public void login_with_invalid_credentials() {
		allProductLis.verifyLoginWithInvalidDetails();
	}

	@When("user create new account")
	public void user_create_new_account() {
		allProductLis.createUserAccount();
	}
	
	@When("user deletes the account")
	public void user_deletes_the_account() {
		allProductLis.deleteAccount();
	}


	@When("user update the account")
	public void user_update_the_account() {
		allProductLis.updateUserAccount();
	}
	
	@When("user get the details")
	public void user_get_the_details() {
		allProductLis.getUserAccountByDetail();
	}

	@Then("User should get the statuscode as {int}")
	@Step
	public void user_should_get_the_statuscode_as(int statuscode) {
		allProductLis.validateStatusCode(statuscode);
	}

	@Then("User should get the responseCode {int}")
	@Step
	public  void user_should_get_the_response_code(int responsecode) {
		allProductLis.validateResponseCode(responsecode);
	}

	@After
	@Then("User responsemessage as {string}")
	@Step
	public void user_responsemessage_as(String string) {
		allProductLis.validateMessageBody(string);
	}


}
