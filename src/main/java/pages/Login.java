package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	//Locating the password text box
	@FindBy(xpath="//input[@type='email']") public WebElement email;
	
}
