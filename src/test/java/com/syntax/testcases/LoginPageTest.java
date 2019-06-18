package com.syntax.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest extends BaseClass{
	
	@Test(groups = "smoke")
	public void loginToOrangeHRM()
	{
		test=report.createTest("Positive login without Page Factory");
		LoginPageWithoutPageFactory login=new LoginPageWithoutPageFactory();
		test.info("Logging in with valid credentials");
		
		CommonMethods.sendText(login.username, "Admin");
		CommonMethods.sendText(login.password, "Xd6J@qWyA");
		CommonMethods.click(login.btnLogin);
		test.info("Verifying dashboard text is displayed");
		
		HomePage home=new HomePage();
		boolean isDisplayed=home.dashboardText.isDisplayed();
		Assert.assertTrue(isDisplayed);
		test.pass("Sucessfuly logged in");
	}
	
	@Test (groups = "smoke")
	public void doLogin()
	{
		//test=report.createTest("Login verification with Page Factory");
		LoginPage login=new LoginPage();
		
		CommonMethods.sendText(login.userName, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);
		
		HomePage home=new HomePage();
		boolean isDisplayed=home.dashboardText.isDisplayed();
		
		//Assert.assertTrue(isDisplayed);
		Assert.assertTrue(false);
		test.pass("Login verification passed");
	}
	
	// Verify user is unable to login with wrong credentials
	
	@Test(groups="regression")
	public void negativeLogin()
	{
		LoginPage login = new LoginPage();
		login.login("test", "pwd");
		String errorText=login.message.getText();
		
		Assert.assertEquals(errorText, "Invalid credentials");
		
		
		
	
	}
	
}

