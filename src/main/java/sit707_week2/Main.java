package sit707_week2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main 
{
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.chrome.driver", "/Users/wenzongxuan/Downloads/chromedriver-mac-arm64/chromedriver");
    	
    	WebDriver driver = new ChromeDriver();
    	try {
            driver.get("https://www.bunnings.com.au/login");
        } finally {
            driver.close();
        }
    }
}
