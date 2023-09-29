package com.automationexercise.steps;

/*
 * @author Ragul
 * 
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.runner.RunWith;
import io.restassured.module.jsv.JsonSchemaValidator;
import com.automationexercise.Routes.TestRoutes;
import com.automationexercise.base.BaseTest;
import com.automationexercise.context.TestContext;
import com.automationexercise.pojo.deserialize.Deserialize;
import com.automationexercise.pojo.deserialize.Deserialize.GetAllProducts;
import com.automationexercise.pojo.deserialize.Deserialize.GetUserAccountDetials;
import com.automationexercise.pojo.putbrands.PutBrands;
import com.automationexercise.pojo.verifyloginwithoutparam.LoginWithoutParamDes;
import com.automationexercise.utilities.Constant;
import com.automationexercise.utilities.ReadProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.security.auth.login.LoginContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.hu.De;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;



@RunWith(SerenityRunner.class)
public class GetAllProductLis extends BaseTest {

	Response response;
	JsonPath json;
	TestContext testcontext;
	ObjectMapper mapper;
	
	//apache log24j
	public static Logger logger =  (Logger) LogManager.getLogger(GetAllProductLis.class);
	ReadProperties read;
	FileInputStream file;


	/**
	 * constructor
	 */
	public GetAllProductLis() {
		testcontext = new TestContext();
		mapper = new ObjectMapper();
		read = new ReadProperties();
	}

	/**
	 * getallproducts get request
	 */
	@Step("get all products")
	public void getAllProducts() {
		logger.info("-----------getAllProductsStarted----------------");
		RestAssured.basePath = TestRoutes.productListEndpoint();
		response = SerenityRest.given().spec(reqBuild()).relaxedHTTPSValidation().contentType(ContentType.JSON).get();

//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			file = new FileInputStream("src/test/resources/JsonSchemVal/getallproducts.JSON");
			response.then().body(JsonSchemaValidator.matchesJsonSchema(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
		
		try {
			GetAllProducts getallproducts = mapper.readValue(response.asString(),
					GetAllProducts.class);

			logger.info("GetAllProducts Deserializing started");
			for (GetAllProducts.Product product : getallproducts.getProducts()) {
				
				logger.info("Id: " + product.getId());
				logger.info("Name: " + product.getName());
				logger.info("Price: " + product.getPrice());
				logger.info("Brand: " + product.getBrand());
				logger.info("Category: " + product.getCategory().getCategory());
				logger.info("User Type: " + product.getCategory().getUsertype().getUsertype());
			}
			logger.info("----------GetAllProducts Deserializing Ended-----------");

		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}


		json = new JsonPath(response.asString());
		int code = json.getInt("responseCode");
		String messagebody = json.getString("message");
		testcontext.setActualresponsecode(code);
		testcontext.setActualresponsemessage(messagebody);

	}

	/**
	 * add product post request
	 */
	@Step("add product")
	public void addProduct() {
		logger.info("-----------addProduct----------------");
		RestAssured.basePath = TestRoutes.productListEndpoint();
		response = SerenityRest.given().spec(reqBuild()).relaxedHTTPSValidation().contentType("application/json").when().post();


		json = new JsonPath(response.asString());
		int code = json.getInt("responseCode");
		String messagebody = json.getString("message");
		testcontext.setActualresponsecode(code);
		testcontext.setActualresponsemessage(messagebody);
		System.out.println(testcontext.getActualresponsecode());
	}

	
	/**
	 * 
	 * @param statuscode
	 * status code
	 */
	@Step("validate status codes {0}")
	public void validateStatusCode(int statuscode) {
//		response.then().assertThat().statusCode(statuscode);
		response.then().spec(responeBuilder(statuscode));
	}

	
	/**
	 * 
	 * @param message
	 * response body
	 */
	@Step("validate message body {0}")
	public  void validateMessageBody(String message) {
		logger.info("-----------validateMessageBody----------------");
		String expectedbodymessage = message;
		String actualbodymessage = testcontext.getActualresponsemessage();
		if (expectedbodymessage.equals(actualbodymessage)) {
			System.out.println("msg one "+expectedbodymessage);
			System.out.println("msg two:"+actualbodymessage);
//			Assert.assertEquals(expectedbodymessage, actualbodymessage,read.getAssertionFailMessage());
			logger.info(read.getAssertionPassMessage());
		} else {
			logger.info(read.getAssertionFailMessage());
		}
		
		Serenity.reportThat("validation passed", () -> Assert.assertEquals(expectedbodymessage, actualbodymessage));
		
	}

	/**
	 * 
	 * @param responsecode
	 * response code
	 */
	@Step("validate response code {0}")
	public void validateResponseCode(int responsecode) {
		System.out.println("-----------validateResponseCode----------------");
		int expectedresponsecode = responsecode;
		int actualresponsecode = testcontext.getActualresponsecode();
		if (actualresponsecode == expectedresponsecode) {
			logger.info(read.getAssertionPassCode());
		} else {
			logger.info(read.getAssertionFailCode());
		}

	}

	/**
	 * getallbrandlist
	 */
	@Step("get all brand list")
	public void getAllBrandList() {
		logger.info("-----------getAllBrandList----------------");
		RestAssured.basePath = TestRoutes.brandListEndpoint();
		response = SerenityRest.given().spec(reqBuild()).relaxedHTTPSValidation().contentType(ContentType.JSON).when().get();

		try {
			Deserialize.GetBrands  getbrands = mapper.readValue(response.asString(), Deserialize.GetBrands.class);
			System.out.println(getbrands.getResponseCode());
			for (Deserialize.GetBrands.Brands brands : getbrands.getBrands()) {
				logger.info("GetBrands Deserializing started");
				logger.info("Id: " + brands.getId());
				logger.info("Brand: " + brands.getBrand());
				logger.info("---------GetBrands Deserializing started------------");
			}
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		response.prettyPrint();
//		response.then().statusCode(200);
	}

	/**
	 * put all brand list
	 */
	@Step("put all brand list")
	public void putAllBrandList() {
		logger.info("-----------putAllBrandList----------------");
		RestAssured.basePath = TestRoutes.brandListEndpoint();
		response = SerenityRest.given().spec(reqBuild()).relaxedHTTPSValidation().contentType(ContentType.URLENC).when().put();
		try {
			Deserialize.PutBrands putbrands = mapper.readValue(response.asString(), Deserialize.PutBrands.class);
			logger.info("PutBrands Deserializing started");
			logger.info(putbrands.getResponseCode());
			logger.info(putbrands.getMessage());
			logger.info("---------PutBrands Deserializing started------------");
			
			

		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		json = new JsonPath(response.asString());
		int code = json.getInt("responseCode");
		String messagebody = json.getString("message");
		testcontext.setActualresponsecode(code);
		testcontext.setActualresponsemessage(messagebody);

	}

	/**
	 * search product
	 */
	@Step("Search product")
	public void searchProduct() {
		logger.info("-----------searchProduct----------------");
		RestAssured.basePath =TestRoutes.searchProductEndpoint();

		response = SerenityRest.given().spec(reqBuild()).relaxedHTTPSValidation().contentType(ContentType.URLENC)
				.formParam(Constant.search_product, Constant.search_product_name).post();
		try {
			GetAllProducts search = mapper.readValue(response.asString(), GetAllProducts.class);
			for (GetAllProducts.Product product : search.getProducts()) {
				logger.info("GetAllProducts Deserializing started");
				
				logger.info(product.getId());
				logger.info(product.getName());
				logger.info(product.getPrice());
				logger.info(product.getBrand());
				logger.info(product.getCategory().getCategory());
				logger.info(product.getCategory().getUsertype().getUsertype());
				logger.info("---------GetAllProducts Deserializing started------------");

			}

		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * search product without param
	 */
	@Step("Search product without param")
	public void searchProductWithoutParam() {
		logger.info("-----------searchProductWithoutParam----------------");
		RestAssured.basePath = TestRoutes.searchProductEndpoint();

		int responesstatucode = 400;
		String responsemessage = "Bad request, search_product parameter is missing in POST request.";

		response = SerenityRest.given().spec(reqBuild()).relaxedHTTPSValidation().contentType(ContentType.URLENC).post();
//		.formParam("password", "kamali5@Automation")
		
		try {
			Deserialize.searchProductWithoutSearchProduct searchwithoutparam=mapper.readValue(response.asString(), Deserialize.searchProductWithoutSearchProduct.class);
			logger.info("searchProductWithoutSearchProduct Deserializing started");
			System.out.println(searchwithoutparam.getResponseCode());
			System.out.println(searchwithoutparam.getMessage());
			logger.info("----------searchProductWithoutSearchProduct Deserializing started----------");
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		int statuscode = response.getBody().jsonPath().get("responseCode");
		String messagebody = response.getBody().jsonPath().getString("message");
		
		testcontext.setActualresponsemessage(messagebody);
		testcontext.setActualresponsecode(statuscode);
	}

	/**
	 * verifylogin
	 */
	@Step("verify login")
	public void verifyLogin() {
		logger.info("-----------verifyLogin----------------");
		RestAssured.basePath = TestRoutes.verifyLoginEndpoint();
		String email = "kamali9@gmail.com";
		String password = "kamali5@Automation";

		// Encode form parameters in URL-encoded format
		String encodedemail = URLEncoder.encode(email, StandardCharsets.UTF_8);
		String encodedpassword = URLEncoder.encode(password, StandardCharsets.UTF_8);

		// Combine the encoded form parameters
		String encodedParams = "email=" + encodedemail + "&password=" + encodedpassword;


		Response res = SerenityRest.given().spec(reqBuild()).relaxedHTTPSValidation().contentType(ContentType.URLENC)
				.formParam(Constant.email, email).formParam(Constant.password, password).post();
		JsonPath resbody = res.getBody().jsonPath();
		String messagecode = resbody.getString("message");
		int status = resbody.getInt("responseCode");
		testcontext.setActualresponsecode(status);
		testcontext.setActualresponsemessage(messagecode);
	}

	/**
	 * verifylogin w/o email parameter
	 */
	@Step("verify login without email parameter")
	public void verifyLoginWithoutEmailParameter() {
		logger.info("-----------verifyLoginWithoutEmailParameter----------------");
		RestAssured.basePath = TestRoutes.verifyLoginEndpoint();
		String password = read.getpassword();

		int responesstatucode = 400;
		String responsemessage = "Bad request, email or password parameter is missing in POST request.";

		// Encode form parameters in URL-encoded format
//		String encodedemail = URLEncoder.encode(email, StandardCharsets.UTF_8);
		String encodedpassword = URLEncoder.encode(password, StandardCharsets.UTF_8);

		// Combine the encoded form parameters
//		String encodedParams = "email=" + encodedemail + "&password=" + encodedpassword;

//		RequestSpecification reqspec = new RequestSpecBuilder().setBaseUri("https://automationexercise.com").setBasePath("/api/verifyLogin").setContentType(ContentType.JSON).build();

		response = SerenityRest.given().spec(reqBuild()).relaxedHTTPSValidation().contentType(ContentType.URLENC)
				.formParam(Constant.password, read.getpassword()).post();
		 
		try {
			Deserialize.LoginWithoutParamDes loginwithoutparam = mapper.readValue(response.asString(), Deserialize.LoginWithoutParamDes.class);
			logger.info("LoginWithoutParamDes Deserializing started");
			logger.info(loginwithoutparam.getResponseCode());
			logger.info(loginwithoutparam.getMessage());
			logger.info("-----LoginWithoutParamDes Deserializing started------");
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	
		JsonPath resbody = response.jsonPath();
		String messagebody = resbody.getString("message");
		int statuscode = resbody.getInt("responseCode");
		testcontext.setActualresponsecode(statuscode);
		testcontext.setActualresponsemessage(messagebody);
		
	}
	
	/**
	 * delete to verify login
	 */
	@Step("delete to verify login")
	public void deleteToVerifyLogin() {
		logger.info("-----------deleteToVerifyLogin----------------");


		int responsecode = 405;
		String messagebody = "This request method is not supported.";

		RestAssured.basePath = TestRoutes.verifyLoginEndpoint();

		response = SerenityRest.given().spec(reqBuild()).relaxedHTTPSValidation().delete();
		try {
			Deserialize.DeleteToVerifyLogin deletlogin=mapper.readValue(response.asString(), Deserialize.DeleteToVerifyLogin.class);
			logger.info("DeleteToVerifyLogin Deserializing started");
			logger.info(deletlogin.getResponseCode());
			logger.info(deletlogin.getMessage());
			logger.info("------------DeleteToVerifyLogin Deserializing started--------");
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(response.asString());
		JsonPath jsonpath = response.jsonPath();
		String extractmsg = jsonpath.getString("message");
		int statuscode = jsonpath.getInt("responseCode");
		testcontext.setActualresponsecode(statuscode);
		testcontext.setActualresponsemessage(extractmsg);

		

	}

	/**
	 * verify login with invalid details
	 */
	@Step("verify login with invalid details")
	public void verifyLoginWithInvalidDetails() {
		logger.info("-----------verifyLoginWithInvalidDetails----------------");
		RestAssured.basePath = TestRoutes.verifyLoginEndpoint();
		String email = read.getInvalidEmail();
		String password = read.getInvalidPassword();

		int responsecode = 404;
		String messagebody = "User not found!";


		response = SerenityRest.given().spec(reqBuild()).relaxedHTTPSValidation().contentType(ContentType.URLENC)
				.formParam("email", email).formParam("password", password).post();

		JsonPath jsonpath = response.jsonPath();
		String extractmsg = jsonpath.getString("message");
		int statuscode = jsonpath.getInt("responseCode");
		testcontext.setActualresponsecode(statuscode);
		testcontext.setActualresponsemessage(extractmsg);
		System.out.println(testcontext.getActualresponsecode());
		System.out.println(testcontext.getActualresponsemessage());

	}
	
	
	
	/**
	 * create new user
	 */
	@Step("create user account")
	public void createUserAccount() {

		logger.info("-----------createUserAccount----------------");
		
		RestAssured.basePath = TestRoutes.createAccountEndpoint();
		
		String name =read.getname();
		String email = read.getemail();
		String password =read.getpassword();
		String title =read.gettitle();
		String birth_date = read.getbirth_date();
		String birth_month = read.getbirth_month();
		String birth_year = read.getbirth_year();
		String firstname = read.getfirstname();
		String lastname =read.getlastname();
		String company = read.getcompany();
		String address1 =read.getaddress1();
		String address2 = read.getaddress2();
		String country = read.getcountry();
		String zipcode = read.getzipcode();
		String state = read.getstate();
		String city = read.getcity();
		String mobile_number = read.getmobile_number();

		String messagebody = "User created!";
		int statuscode = 201;

		response = SerenityRest.given().spec(reqBuild()).relaxedHTTPSValidation().contentType(ContentType.URLENC)
				.formParam(Constant.name, name)
				.formParam(Constant.email, email)
				.formParam(Constant.password, password)
				.formParam(Constant.title, title)
				.formParam(Constant.birth_date, birth_date)
				.formParam(Constant.birth_month, birth_month)
				.formParam(Constant.birth_year, birth_year)
				.formParam(Constant.firstname, firstname)
				.formParam(Constant.lastname, lastname)
				.formParam(Constant.company, company)
				.formParam(Constant.address1, address1)
				.formParam(Constant.address2, address2)
				.formParam(Constant.country, country)
				.formParam(Constant.zipcode, zipcode)
				.formParam(Constant.state, state)
				.formParam(Constant.city, city)
				.formParam(Constant.mobile_number, mobile_number)
				.post();

		response.asString();
		JsonPath json = response.jsonPath();
		int responsecode = json.get("responseCode");
		String extractmessagebody = json.getString("message");
		
		testcontext.setActualresponsecode(responsecode);
		testcontext.setActualresponsemessage(extractmessagebody);	
	}

	/**
	 * delete user account
	 */
	@Step("delete account")
	public void deleteAccount() {
		logger.info("-----------deleteAccount----------------");

		RestAssured.basePath = TestRoutes.deletAccountEndpoint();

		String message = "Account deleted!";
		int statusode = 200;

		response = SerenityRest.given().spec(reqBuild()).relaxedHTTPSValidation().contentType(ContentType.URLENC)
				.formParam(Constant.email, read.getDelEmail()).formParam(Constant.password, read.getDelPassword()).delete();
		JsonPath resbody = response.jsonPath();
		String messagebody = resbody.getString("message");
		int statuscode = resbody.getInt("responseCode");
		testcontext.setActualresponsecode(statuscode);
		testcontext.setActualresponsemessage(messagebody);
	}

	/**
	 * update user account
	 */
	@Step("update user account")
	public void updateUserAccount() {

		logger.info("-----------updateUserAccount----------------");

		RestAssured.basePath = TestRoutes.updateAccountEndpoint();
		String name = read.updatename();
		String email = read.updateemail();
		String password = read.updatepassword();
		String title = read.updatetitle();
		String birth_date = read.updatebirth_date();
		String birth_month = read.updatebirth_month();
		String birth_year = read.updatebirth_year();
		String firstname = read.updatefirstname();
		String lastname = read.updatelastname();
		String company = read.updatecompany();
		String address1 = read.updateaddress1();
		String address2 = read.updateaddress1();
		String country = read.updatecountry();
		String zipcode = read.updatezipcode();
		String state =read.updatestate();
		String city = read.updatecity();
		String mobile_number = read.updatemobile_number();

		String messagebody = "User updated!";
		int statuscode = 200;

		response = SerenityRest.given().spec(reqBuild()).relaxedHTTPSValidation().contentType(ContentType.URLENC)
				.formParam(Constant.name, name)
				.formParam(Constant.email, email)
				.formParam(Constant.password, password)
				.formParam(Constant.title, title)
				.formParam(Constant.birth_date, birth_date)
				.formParam(Constant.birth_month, birth_month)
				.formParam(Constant.birth_year, birth_year)
				.formParam(Constant.firstname, firstname)
				.formParam(Constant.lastname, lastname)
				.formParam(Constant.company, company)
				.formParam(Constant.address1, address1)
				.formParam(Constant.address2, address2)
				.formParam(Constant.country, country)
				.formParam(Constant.zipcode, zipcode)
				.formParam(Constant.state, state)
				.formParam(Constant.city, city)
				.formParam(Constant.mobile_number, mobile_number)
				.put();

		//Store the response in jsonpath class
		JsonPath json = response.jsonPath();
		
		//Extract responseCode from response
		int responsecode = json.getInt(read.responseCode());
		
		//Extract message from response
		String extractmessagebody = json.getString(read.message());


		System.out.println(extractmessagebody);
		testcontext.setActualresponsecode(responsecode);
		testcontext.setActualresponsemessage(extractmessagebody);

	}

	/**
	 * get user account by detail
	 */
	@Step("get user account by detail")
	public void getUserAccountByDetail() {
		logger.info("-----------getUserAccountByDetail----------------");

		RestAssured.basePath = TestRoutes.getUserDetailByEmailEndpoint();

		int expectedresponsecode = 200;

		response = SerenityRest.given().spec(reqBuild()).relaxedHTTPSValidation().contentType(ContentType.URLENC)
				.formParam(Constant.email, read.userAccountEmail()).get();
		
		try {
			Deserialize.GetUserAccountDetials getuserdetails =  mapper.readValue(response.asString(), Deserialize.GetUserAccountDetials.class);
			logger.info("GetUserAccountDetials Deserilizing started");
			GetUserAccountDetials.User user = getuserdetails.getUser();
			logger.info(Constant.ID + user.getId());
			logger.info(Constant.name + user.getName());
			logger.info(Constant.email + user.getEmail());
			logger.info(Constant.title + user.getTitle());
			logger.info(Constant.birth_date+ user.getBirth_day());
			logger.info(Constant.birth_month + user.getBirth_month());
			logger.info(Constant.birth_year + user.getBirth_year());
			logger.info(Constant.firstname + user.getFirst_name());
			logger.info(Constant.lastname + user.getLast_name());
			logger.info(Constant.company + user.getCompany());
			logger.info(Constant.address1 + user.getAddress1());
			logger.info(Constant.address2 + user.getAddress2());
			logger.info(Constant.country + user.getCountry());
			logger.info(Constant.state + user.getState());
			logger.info(Constant.city + user.getCity());
			logger.info(Constant.zipcode + user.getZipcode());
            logger.info("GetUserAccountDetials Deserilizing started");
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
