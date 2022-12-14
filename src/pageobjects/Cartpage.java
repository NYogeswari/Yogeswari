package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractcomponents.Abstractcomponents;

public class Cartpage extends Abstractcomponents {

	WebDriver driver;

	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cart;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkout;

	public void Cartpage()  {
		cart.click();
	}

	public void VerifyProductDisplay() throws InterruptedException {

		// WebElement checkOut =
		// driver.findElement(By.xpath("//button[text()='Checkout']"));

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView(true)", checkout);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		Actions act = new Actions(driver);
		act.moveToElement(checkout);

		checkout.click();

	

	}
}
