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

public class SeleniumOperationsW3School {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void W3School_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/Users/wenzongxuan/Downloads/chromedriver-mac-arm64/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		
		WebElement email = driver.findElement(By.id("modalusername"));
	    email.sendKeys("123456@gmail.com");
	    
	    WebElement signUpButton = driver.findElement(By.xpath("//button[.//span[text()='Sign up for free']]"));
	    signUpButton.click();

		/*
		 * Take screenshot using selenium API.
		 */
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    try {
	        FileUtils.copyFile(scrFile, new File("/Users/wenzongxuan/Downloads/screenshot2.png"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}

}
