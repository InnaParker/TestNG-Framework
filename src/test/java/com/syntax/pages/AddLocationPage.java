package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.syntax.utils.BaseClass;

public class AddLocationPage extends BaseClass{

	@FindBy(id="admin")
    public WebElement admin;
    
    @FindBy(id="organization")
    public WebElement organization;
    
    @FindBy(id="location")
    public WebElement location;
    
    @FindBy(id="add")
    public WebElement add;
	
}
