package com.automationexercise.Routes;

/**
 * @author Ragul
 * 
 */
public class TestRoutes {

	/**
	 * 
	 * @return
	 * productlist endpoint
	 */
	public static String productListEndpoint() {
		String productlist = "/api/productsList";
		return productlist;
	}

	/**
	 * 
	 * @return
	 * brandlist endpoint
	 */
	public static String brandListEndpoint() {
		String productlist = "/api/brandsList";
		return productlist;
	}

	/**
	 * 
	 * @return
	 * search product endpoint
	 */
	public static String searchProductEndpoint() {
		String searchproduct = "/api/searchProduct";
		return searchproduct;
	}

	/**
	 * 
	 * @return
	 * verifylogin endpoint
	 */
	public static String verifyLoginEndpoint() {
		String searchproduct = "/api/verifyLogin";
		return searchproduct;
	}

	/**
	 * 
	 * @return
	 * create account endpoint
	 */
	public static String createAccountEndpoint() {
		String createAccount = "/api/createAccount";
		return createAccount;
	}

	/**
	 * @return
	 * deleteaccount endpoint
	 */
	public static String deletAccountEndpoint() {
		String deleteAccount = "/api/deleteAccount";
		return deleteAccount;
	}

	/**
	 * @return
	 * update account endpoint
	 */
	public static String updateAccountEndpoint() {
		String updateAccount = "/api/updateAccount";
		return updateAccount;
	}

	/**
	 * 
	 * @return
	 * get user detail by email endpoint
	 */
	public static String getUserDetailByEmailEndpoint() {
		String getdetailsbyemail = "/api/getUserDetailByEmail";
		return getdetailsbyemail;
	}
	
	
}
