package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmationpage {

	WebDriver driver;

	public Confirmationpage(WebDriver driver) {
		// super(driver);
		this.driver = driver;
		//PageFactory.initElements(driver, this);

	}
	//@FindBy(css="toast-container")
   // WebElement confirmationMessage;
	
	  public void getconfirmationMessage() 
      {
		  
        //confirmationMessage.getText();
		 System.out.println(" Thanks your order placed successfully");
		

      }
}