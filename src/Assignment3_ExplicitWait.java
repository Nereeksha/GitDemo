import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

//Section 9 Assignment
public class Assignment3_ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Chandu N Nereeksha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		String[] phones = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };

		// username and password
		driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");

		// radio button and alert
		driver.findElement(By.xpath("(//*[@class='customradio']/span)[4]")).click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();

		// dropdown
		WebElement staticDropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select dropdown = new Select(staticDropdown);

		dropdown.selectByIndex(2);

		// checkbox and sign in
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();

		// addPhoneItems(driver, phones);

		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
		List<WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));

		for (int i = 0; i < products.size(); i++)
		{
			products.get(i).click();
		} */
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".nav-link.btn.btn-primary")));
		List<WebElement> totalPhones = driver.findElements(By.xpath("//h4/a"));

		for (int i = 0; i < totalPhones.size(); i++) {
			String phoneName = totalPhones.get(i).getText();
			List<String> phoneItems = Arrays.asList(phones);
			if (phoneItems.contains(phoneName)) {
				driver.findElements(By.cssSelector("button.btn.btn-info")).get(i).click();
			}
		}
		
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();

	}
}
