package testobjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractcomponents.Abstractcomponents;
import pageobjects.Cartpage;
import pageobjects.Checkoutpage;
import pageobjects.Confirmationpage;
import pageobjects.Login;
import pageobjects.ProductCatalog;

public class LetsShopMain {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\n.yogeswari\\Downloads\\chromedriver_win32 (3)//chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();
		Login log = new Login(driver);
		log.goTo();
		log.loginApplication();

		ProductCatalog productcatalog = new ProductCatalog(driver);
		productcatalog.addItems();
		Cartpage cart = new Cartpage(driver);
		cart.Cartpage();
		cart.VerifyProductDisplay();
		Checkoutpage checkout = new Checkoutpage(driver);
		checkout.SelectCountry();
		Confirmationpage confirmation = new Confirmationpage(driver);
		confirmation.getconfirmationMessage();

	}

}
