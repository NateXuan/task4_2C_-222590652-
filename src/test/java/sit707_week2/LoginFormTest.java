package sit707_week2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFormTest {
	
	public LoginFormTest() {
		System.out.println("MainTest");
	}
	
	private WebDriver driver;
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/wenzongxuan/Downloads/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
    }
	
	@Test
	public void testStudentIdentity() {
		String studentId = "222590652";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Wenzong Xuan";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testLoginEmptyUsernameAndPassword() {
        String result = SeleniumOperations.bunningsLoginPage(driver, "https://www.bunnings.com.au/login", "", "");
        Assert.assertTrue(result.contains("Please correct the highlighted errors") || result.contains("This field is required"));
    }

    @Test
    public void testLoginInvalidUsernameAndPassword() {
        String result = SeleniumOperations.bunningsLoginPage(driver, "https://www.bunnings.com.au/login", "111@example.com", "111111");
        Assert.assertEquals("Your email address or password is incorrect.", result);
    }
    
    @Test
    public void testLoginSuccessful() {
    	//assume the email and the password are correct.
        String result = SeleniumOperations.bunningsLoginPage(driver, "https://www.bunnings.com.au/login", "123@gmail.com", "321");
        Assert.assertEquals("Login successful", result);
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
