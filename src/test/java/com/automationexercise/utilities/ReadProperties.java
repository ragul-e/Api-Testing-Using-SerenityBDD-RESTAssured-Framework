package com.automationexercise.utilities;

/**
 * @author RagulRaj
 * 
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	Properties property;
	File file;
	FileInputStream fileinput;

	
	public ReadProperties() {
		file = new File("src/test/resources/Configuration/config.properties");
		try {
			fileinput = new FileInputStream(file);
			property = new Properties();
			property.load(fileinput);
		} catch (IOException e) {
			System.out.println("Exception:" + e.getMessage());
		}

	}

	public String getbaseUri() {

		return property.getProperty("baseuri");
	}

	public String updatename() {

		return property.getProperty("Updatename");
	}

	public String updateemail() {

		return property.getProperty("Updateemail");
	}

	public String updatepassword() {

		return property.getProperty("Updatepassword");
	}

	public String updatetitle() {

		return property.getProperty("Updatetitle");
	}

	public String updatebirth_date() {

		return property.getProperty("Updatebirth_date");
	}

	public String updatebirth_month() {

		return property.getProperty("Updatebirth_month");
	}

	public String updatebirth_year() {

		return property.getProperty("Updatebirth_year");
	}

	public String updatefirstname() {

		return property.getProperty("Updatefirstname");
	}

	public String updatelastname() {

		return property.getProperty("Updatelastname");
	}

	public String updatecompany() {

		return property.getProperty("Updatecompany");
	}

	public String updateaddress1() {

		return property.getProperty("Updateaddress1");
	}

	public String updateaddress2() {

		return property.getProperty("Updateaddress2");
	}

	public String updatecountry() {

		return property.getProperty("Updatecountry");
	}

	public String updatezipcode() {

		return property.getProperty("Updatezipcode");
	}

	public String updatestate() {

		return property.getProperty("Updatestate");
	}

	public String updatecity() {

		return property.getProperty("Updatecity");
	}

	public String updatemobile_number() {

		return property.getProperty("Updatemobile_number");
	}

	public String getname() {

		return property.getProperty("name");
	}

	public String getemail() {

		return property.getProperty("email");
	}

	public String getpassword() {

		return property.getProperty("password");
	}

	public String gettitle() {

		return property.getProperty("title");
	}

	public String getbirth_date() {

		return property.getProperty("birth_date");
	}

	public String getbirth_month() {

		return property.getProperty("birth_month");
	}

	public String getbirth_year() {

		return property.getProperty("birth_year");
	}

	public String getfirstname() {

		return property.getProperty("firstname");
	}

	public String getlastname() {

		return property.getProperty("lastname");
	}

	public String getcompany() {

		return property.getProperty("company");
	}

	public String getaddress1() {

		return property.getProperty("address1");
	}

	public String getaddress2() {

		return property.getProperty("address2");
	}

	public String getcountry() {

		return property.getProperty("country");
	}

	public String getzipcode() {

		return property.getProperty("zipcode");
	}

	public String getstate() {

		return property.getProperty("state");
	}

	public String getcity() {

		return property.getProperty("city");
	}

	public String getmobile_number() {

		return property.getProperty("mobile_number");
	}

	public String getInvalidEmail() {
		return property.getProperty("Invalidemail");
	}

	public String getInvalidPassword() {
		return property.getProperty("Invalidpassword");
	}

	public String geDelName() {
		return property.getProperty("Delname");
	}

	public String getDelEmail() {
		return property.getProperty("Delemail");

	}

	public String getDelPassword() {
		return property.getProperty("Delpassword");
	}

	public String getAssertionFailMessage() {
		return property.getProperty("AssertionFailMessage");
	}

	public String getAssertionPassMessage() {
		return property.getProperty("AssertionPassMessage");
	}

	public String getAssertionFailCode() {
		return property.getProperty("AssertionFailCode");
	}

	public String getAssertionPassCode() {
		return property.getProperty("AssertionPassCode");
	}

	public String responseCode() {
		return property.getProperty("responsecode");
	}

	public String message() {
		return property.getProperty("message");
	}

	public String userAccountEmail() {
		return property.getProperty("useraccountEmail");
	}

}
