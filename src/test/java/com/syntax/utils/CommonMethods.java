package com.syntax.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends BaseClass{
	
	// CMD + O will provide list of methods for that class
	
	
/**
 * Find element by CSS/Xpath/LinkText
 */
	public static WebElement findByCSS(String element)
	{
		WebElement ele=driver.findElement(By.cssSelector(element));
		return ele;
	}
	
	public static WebElement findByXpath(String element)
	{
		WebElement ele=driver.findElement(By.xpath(element));
		return ele;
	}
	
	public static WebElement findByLinkText(String element)
	{
		WebElement ele=driver.findElement(By.linkText(element));
		return ele;
	}

/**
 * @author inna
 * This method will select specified value from a drop-down by Text
 * @param Select element, String text
 */
	
	public static void selectValueFromDD (WebElement element, String text) 
	{
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean isSelected=false;
		
		for (WebElement option: options) {
			
			String optionText = option.getText();
			
			if (optionText.equals(text)) {
				
			select.selectByVisibleText(text);
			isSelected=true;
			break;
			
			}
		  }
		
		if (!isSelected) {
			
			System.out.println("Option with text "+text+" is not available");
		}
	}
	
/**
* @author inna
* This method will select specified value from a drop-down by it's index
* @param Select element, int index
*/	
	public static void selectValueFromDD(WebElement element, int index) 
	{
		 Select select = new Select(element);
		 List<WebElement> options = select.getOptions();
		 
		 if (options.size() > index) {
			 select.selectByIndex(index);
		 
		 }else {
			 
		 System.out.println("Invalid index has been passed");
		 
		 }
	}
	
	public static void sendText(WebElement element, String value) 
	{
		element.clear();
		element.sendKeys(value);
	}
	
	public static void click(WebElement element)
	{
		element.click();
	}
	

/**
 * Method will accept alert
 * @throws NoAlertPresentException if alert is not present 
 * @return accept alert	
 */
	
	public static void acceptAlert()
	{
		try {
			
			Alert alert=driver.switchTo().alert();
			alert.accept();
			
		} catch(NoAlertPresentException e) {
			
			System.out.println("Alert was not present");
		}
	}
	
/**
* Method will dismiss alert
* @throws NoAlertPresentException if alert is not present 	
*/	
	public static void dimissAlert()
	{
		try {
			
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
			
		} catch(NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}
	
/**
* Method will get text of alert
* @throws NoAlertPresentException if alert is not present 
* @return String text	
*/		
	public static String getAlertText()
	{
		try {
			
			Alert alert=driver.switchTo().alert();
			return alert.getText();
			
		} catch(NoAlertPresentException e) {
			System.out.println("Alert was not present");
			return null;
		}
	}
	
/**
* Method will switch control to the specified frame
* @param frame ID or frame Name	
*/			
	public static void switchToFrame(String idOrName)
	{
		try {
			
			driver.switchTo().frame(idOrName);
			
		} catch(NoSuchFrameException e) {
			
			System.out.println("Frame is not present");
		}
	}
	
/**
* Method will switch control to the specified frame by element
* @param frame element/WEbElement
* @throws NoSuchFrameException if there is no frame on the page
*/			
	public static void switchToFrame(WebElement element)
	{
		try {
			
			driver.switchTo().frame(element);
			
		} catch(NoSuchFrameException e) {
			
			System.out.println("Frame is not present");
		}
	}
		
/**
* Method will switch control to the specified frame by index
* @param frame index
*/			
	public static void switchToFrame(int index)
	{
		try {
			
			driver.switchTo().frame(index);
			
		} catch(NoSuchFrameException e) {
			
			System.out.println("Frame is not present");
		}
	}
	
/**
 * Method will move mouse over the element
 * @param WebElement
 */
	
	public static void mouseOver(WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
/**
 * Method will select radio button
 * @param WebElement
 */
	
	public static void radioButtonClick(WebElement element)
	{
		boolean displayed=element.isDisplayed();
		boolean enabled=element.isEnabled();
		boolean selected=element.isSelected();
		
		if (displayed && enabled) {
			
			if(!selected) {
				element.click();
			}
		}
	}
	
/**
 * Method will click check box
 * @param WebElement, String
 */
	
	public static void checkBoxClick(List<WebElement> element, String value)
	{
		for (WebElement run: element) {
			if (run.isDisplayed() && run.isEnabled()) {
				String text=run.getAttribute("value");
				run.click();
			}
		}
	}
	
/**
 * Method to compare values
 */
	
	public static void compareValue(WebElement element, String value)
	{
		String present=element.getAttribute("value");
		if (present.contains(value)) {
			System.out.println(value+" are matching. PASS");
			
		} else {
			System.out.println(value+" are not matching. FAIL");
		}
	}
	
/**
 * Draw red border
 */
	
	public static void drawBorder(WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border=4px solid red", element);
		
	}

/**
 * @author inna
 * Method will pick specified month and date on the calendar.
 * Get common attribute, put it into list and iterate.
 */
	public static void calendarDatePick()
	{
		// Going thru Months
		while (!driver.findElement(By.cssSelector("")).getText().contains("March")) {
			
			driver.findElement(By.cssSelector("")).click();
		}
		
		// Going thru dates
		List<WebElement> dates=driver.findElements(By.className("day"));
		int count=driver.findElements(By.className("day")).size();
		
		for(int i=0; i<count; i++) {
			String text=driver.findElements(By.className("day")).get(i).getText();
			
			if (text.equalsIgnoreCase("23")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
			
		}
	}
/**
 * Method that will wait for element to be visible
 * @param WebElement element
 * @param int time
 */
	public static void waitForElementBeVisible(WebElement element, int time)
	{
	WebDriverWait wait=new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.invisibilityOf(element));

	}

	public static void waitForElementBeVisible(By locator, int time)
	{
	WebDriverWait wait=new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public static void waitForElementBeClickable(WebElement element, int time)
	{
	WebDriverWait wait=new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void waitForElementBeClickable(By locator, int time)
	{
	WebDriverWait wait=new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.elementToBeClickable(locator));

	}
	
/**
 * This Method that will take screen shot 
 * @param fileName
 */
	
	public static String takeScreenshot(String fileName)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File scr=ts.getScreenshotAs(OutputType.FILE);
		
		String dest=System.getProperty("user.dir")+"/target/screenshots/"+fileName+".png";
		
		try {
			FileUtils.copyFile(scr, new File(dest));
		} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Unable to take screenshot");
		}
		return dest;
		
	}
	
	public static void scrollDown(int pixels)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+pixels+")");
	}
	
	public static void scrollUp(int pixels)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-"+pixels+")");
	}
	
/**
 * This Java Script method will click on web element	
 * @param element
 */
	public static void jsClick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	
	public static void selectList(WebElement element, String text)
	{
		List<WebElement> listLocations = element.findElements(By.tagName("li"));
		for (WebElement li : listLocations) {
			String liText = li.getAttribute("innerHTML");

			if (liText.contains(text)) {
				li.click();
				break;
			}
		}
	}
	
	
	
	
	
}
