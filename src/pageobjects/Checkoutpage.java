package pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractcomponents.Abstractcomponents;

public class Checkoutpage extends Abstractcomponents {
	WebDriver driver;

	public Checkoutpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder=\"Select Country\"]")
	WebElement Country;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement IndiaSelected;

	@FindBy(xpath = "//a[normalize-space()='Place Order']")
	WebElement placeorder;

	public void SelectCountry() throws InterruptedException, IOException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, -200)");

		Properties pro = new Properties();
		FileInputStream files = new FileInputStream(
				"C:\\Users\\n.yogeswari\\eclipse-workspace\\Google\\src\\PropertyFile\\Assignment.properties");
		pro.load(files);
		Thread.sleep(2000);
		Country.click();
		String place = pro.getProperty("place");
		Thread.sleep(3000);

		Country.sendKeys(place);
		Thread.sleep(1000);
		IndiaSelected.click();
		Thread.sleep(7000);
		placeorder.click();

	}

}
