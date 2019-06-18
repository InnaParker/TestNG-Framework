package com.syntax.testcases;

import org.testng.annotations.Test;

import com.syntax.pages.AddLocationPage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class AddLocationPageTest extends BaseClass {

	@Test(dataProvider = "add location")
	public void addLocation(String name, String country, String city, String zip) {
		LoginPage login = new LoginPage();
		HomePage home = new HomePage();
		AddLocationPage location = new AddLocationPage();

		// Login to Orange HRM
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

		//CommonMethods.click(home.admin);
		//CommonMethods.click(home.organization);
		//CommonMethods.click(home.location);
		///CommonMethods.click(home.add);
	}

}
