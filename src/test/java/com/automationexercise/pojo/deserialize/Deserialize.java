package com.automationexercise.pojo.deserialize;

import java.util.List;

/**
 * @author Ragul
 * 
 */
public class Deserialize {

	/*
	 * DeletetoVerifyLogin response
	 */
	public static class DeleteToVerifyLogin {
		int responseCode;
		String message;

		public int getResponseCode() {
			return responseCode;
		}

		public void setResponseCode(int responseCode) {
			this.responseCode = responseCode;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

	/*
	 * loginwithoutparam response
	 */
	public static class LoginWithoutParamDes {

		int responseCode;
		String message;

		public int getResponseCode() {
			return responseCode;
		}

		public void setResponseCode(int responseCode) {
			this.responseCode = responseCode;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}

	/*
	 * searchProductWithoutSearch response
	 */
	public static class searchProductWithoutSearchProduct {
		int responseCode;
		String message;

		public int getResponseCode() {
			return responseCode;
		}

		public void setResponseCode(int responseCode) {
			this.responseCode = responseCode;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

	/*
	 * put brands response
	 */
	public static class PutBrands {

		int responseCode;
		String message;

		public int getResponseCode() {
			return responseCode;
		}

		public void setResponseCode(int responseCode) {
			this.responseCode = responseCode;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

	/*
	 * getbrands response
	 */
	public static class GetBrands {

		List<Brands> brands;
		int responseCode;

		public int getResponseCode() {
			return responseCode;
		}

		public void setResponseCode(int responseCode) {
			this.responseCode = responseCode;
		}

		public List<Brands> getBrands() {
			return brands;
		}

		public void setBrands(List<Brands> brands) {
			this.brands = brands;
		}

		/*
		 * brands response
		 */
		public static class Brands {

			int id;
			String brand;

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getBrand() {
				return brand;
			}

			public void setBrand(String brand) {
				this.brand = brand;
			}

		}

	}

	/*
	 * getAllProduct response
	 */
	public static class GetAllProducts {
		private int responseCode;
		private List<Product> products;

		public int getResponseCode() {
			return responseCode;
		}

		public void setResponseCode(int responseCode) {
			this.responseCode = responseCode;
		}

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}

		/*
		 * product response
		 */
		public static class Product {
			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getPrice() {
				return price;
			}

			public void setPrice(String price) {
				this.price = price;
			}

			public String getBrand() {
				return brand;
			}

			public void setBrand(String brand) {
				this.brand = brand;
			}

			public Category getCategory() {
				return category;
			}

			public void setCategory(Category category) {
				this.category = category;
			}

			private int id;
			private String name;
			private String price;
			private String brand;
			private Category category;

		}

		/*
		 * Category respones
		 */
		public static  class Category {
			public UserType getUsertype() {
				return usertype;
			}

			public void setUsertype(UserType usertype) {
				this.usertype = usertype;
			}

			public String getCategory() {
				return category;
			}

			public void setCategory(String category) {
				this.category = category;
			}

			private UserType usertype;
			private String category;

		}

		/*
		 * UserType response
		 */
		public  static class UserType {
			public String getUsertype() {
				return usertype;
			}

			public void setUsertype(String usertype) {
				this.usertype = usertype;
			}

			private String usertype;

		}

	}
	
	/*
	 * getuserAccountDetails response
	 */
	public static class GetUserAccountDetials{
		int responseCode;
		User user;
		
		public int getResponseCode() {
			return responseCode;
		}

		public void setResponseCode(int responseCode) {
			this.responseCode = responseCode;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		
		/*
		 * User response
		 */
		public static class User{
			public int id;
			public String name;
			public String email;
			public String title;
			public String birth_day;
			public String birth_month;
			public String birth_year;
			public String first_name;
			public String last_name;
			public String company;
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getBirth_day() {
				return birth_day;
			}
			public void setBirth_day(String birth_day) {
				this.birth_day = birth_day;
			}
			public String getBirth_month() {
				return birth_month;
			}
			public void setBirth_month(String birth_month) {
				this.birth_month = birth_month;
			}
			public String getBirth_year() {
				return birth_year;
			}
			public void setBirth_year(String birth_year) {
				this.birth_year = birth_year;
			}
			public String getFirst_name() {
				return first_name;
			}
			public void setFirst_name(String first_name) {
				this.first_name = first_name;
			}
			public String getLast_name() {
				return last_name;
			}
			public void setLast_name(String last_name) {
				this.last_name = last_name;
			}
			public String getCompany() {
				return company;
			}
			public void setCompany(String company) {
				this.company = company;
			}
			public String getAddress1() {
				return address1;
			}
			public void setAddress1(String address1) {
				this.address1 = address1;
			}
			public String getAddress2() {
				return address2;
			}
			public void setAddress2(String address2) {
				this.address2 = address2;
			}
			public String getCountry() {
				return country;
			}
			public void setCountry(String country) {
				this.country = country;
			}
			public String getState() {
				return state;
			}
			public void setState(String state) {
				this.state = state;
			}
			public String getCity() {
				return city;
			}
			public void setCity(String city) {
				this.city = city;
			}
			public String getZipcode() {
				return zipcode;
			}
			public void setZipcode(String zipcode) {
				this.zipcode = zipcode;
			}
			private String address1;
		    private String address2;
		    private String country;
		    private String state;
		    private String city;
		    private String zipcode;
			
		}
		
	}
	

}
