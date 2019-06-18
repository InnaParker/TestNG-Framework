package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

public class LoginPage extends BaseClass {

	// Locating WebElemnts using @FindBy annotation

	@FindBy(id = "txtUsername")
	public WebElement userName;

	@FindBy(name = "txtPassword")
	public WebElement password;

	@FindBy(id = "btnLogin")
	public WebElement loginBtn;

	@FindBy(css = "img[src*='logo.png']")
	public WebElement logo;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	public WebElement message;
	

	// Initializing instance all instance variables with constructor

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}
	
	public void login(String uname, String pwd )
	{
		CommonMethods.sendText(userName, uname);
		CommonMethods.sendText(password, pwd);
		CommonMethods.click(loginBtn);
	}
}
