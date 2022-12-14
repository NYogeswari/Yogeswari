
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LetsShop {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\n.yogeswari\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String[] itemsNeeded = { "ZARA COAT 3", "ADIDAS ORIGINAL", "IPHONE 13 PRO" };
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("sun@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Jack@123");
		driver.findElement(By.id("login")).click();
		addItems(driver, itemsNeeded);
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		
		 WebElement ele=driver.findElement(By.xpath("//button[text()='Checkout']"));
		 Thread.sleep(5000);
		 
		
		/* WebElement checkOut = driver.findElement(By.xpath("//button[text()='Checkout']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true)", checkOut);
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//button[text()='Checkout']")).click();*/


		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();

		/*Boolean bool = driver.findElement(By.xpath("//button[text()='Checkout']")).isEnabled();
		if (bool == true) {
			driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		}*/
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			//	 driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]"));
		 driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")).sendKeys("india");
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		 
		 Thread.sleep(1000);
		// driver.findElement(By.xpath("//a[@class = 'btnn action_submit ng-star-inserted']")).click();
		 driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
		 //driver.findElement(By.id("toast-container")).getText();
		 System.out.println(" Thanks your order placed successfully");
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j = 0;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='container']//div[@class='row']//h5")));
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='container']//div[@class='row']//h5"));

		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			List itemsNeedlist = Arrays.asList(itemsNeeded);
			if (itemsNeedlist.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//section[@id='products']//button[2]")).get(i).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
				wait.until(ExpectedConditions
						.invisibilityOfAllElements(driver.findElements(By.cssSelector(".ng-animating"))));
				if (j == itemsNeeded.length) {
					System.out.println(" ZARA COAT 3 is added successfully");
					System.out.println(" ADIDAS ORIGINAL is added successfully");
					System.out.println(" IPHONE 13 PRO is added successfully");
					break;
				}
			}
		}
	}
}