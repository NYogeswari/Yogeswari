package Cucumber.stepDefinition;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Cartpage;
import pageobjects.Checkoutpage;
import pageobjects.Confirmationpage;
import pageobjects.Login;
import pageobjects.ProductCatalog;

public class StepDefinition {
	 WebDriver driver;

	@Given("^log in with username (.+) and password (.+)$")
	public void log_in_with_username_and_password(String userEmail, String userPassword) throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\n.yogeswari\\Downloads\\chromedriver_win32 (3)//chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();
		Login log = new Login(driver);
		log.goTo();
		log.loginApplication();
	}

	@When("I add product to CartPage")
	public void add_product_to_cart() throws IOException, InterruptedException {
		ProductCatalog productcatalog = new ProductCatalog(driver);
		productcatalog.addItems();
		Cartpage cart = new Cartpage(driver);
		cart.Cartpage();
		cart.VerifyProductDisplay();
	}

	@When("Checkout and submit the order")
	public void Checkout_page() throws InterruptedException, IOException {

		Checkoutpage checkout = new Checkoutpage(driver);
		checkout.SelectCountry();
	}

	@Then("ConfirmationPage")
	public void ConfirmationPage() throws InterruptedException {
		Confirmationpage confirmation = new Confirmationpage(driver);
		confirmation.getconfirmationMessage();

	}
}
