package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils; 
import java.io.File;
import java.io.IOException;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/Users/wenzongxuan/Downloads/chromedriver-mac-arm64/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement firstName = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + firstName);
		// Send first name
		firstName.sendKeys("Wenzong");
		
		/*
		 * Find following input fields and populate with values
		 */
		WebElement lastName = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + lastName);
	    lastName.sendKeys("Xuan");
		
	    WebElement phone = driver.findElement(By.id("phoneNumber"));
		System.out.println("Found element: " + phone);
		phone.sendKeys("0400000000");
		
		WebElement email = driver.findElement(By.id("email"));
	    email.sendKeys("123456@gmail.com");
	    
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
	    WebElement createAccountButton = driver.findElement(By.xpath("//button[@data-testid='account-action-btn']"));
	    createAccountButton.click();
		
		
		/*
		 * Take screenshot using selenium API.
		 */
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    try {
	        FileUtils.copyFile(scrFile, new File("/Users/wenzongxuan/Downloads/screenshot.png"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	
}
