package sit707_week2;

/**
 * Hello world!
 * @author Ahsan Habib
 */
public class Main 
{
    public static void main( String[] args )
    {
    	int choice = 2;

		switch (choice) {
		case 1:
			SeleniumOperations.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
			break;
		case 2:
			SeleniumOperationsW3School.W3School_registration_page("https://profile.w3schools.com/sign-up?redirect_url=https%3A%2F%2Fwww.w3schools.com%2Fhowto%2Fhowto_css_register_form.asp");
			break;
		default:
			System.out.println("Invalid choice.");
			break;
		}
    }
}
