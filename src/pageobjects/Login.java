package pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {


		WebDriver driver;
		public Login(WebDriver driver)
		{
			// super(driver);
		        this.driver=driver;
		        PageFactory.initElements(driver, this);
		}
	
		@FindBy(id="userEmail")
	    WebElement useremail;
		
		@FindBy(id="userPassword")
	    WebElement userpassword;
		
		@FindBy(id="login")
	    WebElement login;
		
		public void loginApplication() throws IOException {
			
			
			Properties pro=new Properties();
			FileInputStream files=new FileInputStream("C:\\Users\\n.yogeswari\\eclipse-workspace\\Assignment\\src\\PropertyFile\\Assignment.properties");
			pro.load(files);
			String Email= pro.getProperty("userEmail");
			String Password=pro.getProperty("userPassword");
			
			
			useremail.sendKeys(Email);
			userpassword.sendKeys(Password);
           login.click();
			
	      
				}
		  public void goTo()
	      {
			  driver.get("https://rahulshettyacademy.com/client/");
			  System.out.println(" Login successfully");

	       }
			
}
