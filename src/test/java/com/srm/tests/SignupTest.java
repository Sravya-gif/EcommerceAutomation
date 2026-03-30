package com.srm.tests;

import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.SignupPage;

public class SignupTest extends BaseTest {

	@Test(dataProvider = "signupData", dataProviderClass = DataProviders.class)
	public void signupTest(String name, String lastname, String title,
	                       String day, String month, String year,
	                       String email, String password,
	                       String company, String address,
	                       String city, String state,
	                       String zip, String mobile) throws Exception {

	    SignupPage signup = new SignupPage(driver);

	    signup.clickSignupLogin();

	    Thread.sleep(2000);

	    signup.enterSignupNameEmail(name, email);

	    Thread.sleep(2000);

	    signup.fillAccountInfo(password, day, month, year);

	    signup.fillAddressInfo(name, lastname, company,
	            address, city, state, zip, mobile);

	    signup.clickCreateAccount();
	    signup.clickContinue();

	    System.out.println("Signup completed for: " + email);
	}
}