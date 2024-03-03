package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static String bunningsLoginPage(WebDriver driver, String url, String email, String password) {
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		driver.get(url);
		
		// Locate and fill the email field
        WebElement emailField = driver.findElement(By.id("okta-signin-username"));
        emailField.sendKeys(email);

        // Locate and fill the password field
        WebElement passwordField = driver.findElement(By.id("okta-signin-password"));
        passwordField.sendKeys(password);
	    
        // Locate and click the sign-in button
        WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
        loginButton.click();
		
		sleep(2);
		
		// Check for error messages
	    List<WebElement> errorMessages = driver.findElements(By.cssSelector(".okta-form-infobox-error p"));
	    if (!errorMessages.isEmpty()) {
	        return errorMessages.get(0).getText();
	    }
	    
	    // Check for the presence of the "Shop now" button to confirm login success
        List<WebElement> shopNowButtons = driver.findElements(By.xpath("//a[contains(@title, 'Shop now')]"));
        if (!shopNowButtons.isEmpty()) {
            return "Login successful";
        }
	    
	    return "Login status unknown";
	}
	
	
}
