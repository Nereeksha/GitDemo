import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Section 8 Ch-71, Ch-72, Ch-73, Ch-74, Ch-75
//Section 9 Ch-79, Ch-80, Ch-81
public class Base_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Chandu N Nereeksha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//implicit wait - also present in Locators_Ex_2.java
		//5s is the max time it will wait before fail, this is declared globally
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);

		// expected vegetables to be selected
		String[] vegList = { "Cucumber", "Brocolli", "Beetroot" };

		addItems(driver, vegList);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("(//*[@class='action-block']/button)[1]")).click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoBtn")));
		
		//redirects to next page, enter promo code
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		//explicit wait
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='promoInfo']")));
		System.out.println(driver.findElement(By.xpath("//*[@class='promoInfo']")).getText());

	}

	public static void addItems(WebDriver driver, String[] vegList) {
		// Trying to make the code generic
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		int j = 0; // variable to check how many times the if condition is run and exit it if it
					// has run for three times since there are three items only

		for (int i = 0; i < products.size(); i++) {
			// String name = products.get(i).getText();
			// format it to get the actual vegetable name
			// Cucumber - 1kg to Cucumber
			String[] name = products.get(i).getText().split("-");
			// name[0] will have Cucumber
			String formattedName = name[0].trim();

			// convert array to arraylist fo easy search
			// check whether the name you extracted is present in array or not

			List<String> items = Arrays.asList(vegList);
			// System.out.println(items.size());

			// if(name.contains("Cucumber"))
			// checks whether the name has any of the items from items/veglist array
			if (items.contains(formattedName)) {
				// Click on Add to cart
				// click the add to cart button whose index is same as any if of the vegList
				// index(Cucumber, brocolli, beetroot)
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// if it's run for 3 times then break
				// if(j == 3)
				if (j == items.size()) {
					break;
				}
			}
		}
	}

}
