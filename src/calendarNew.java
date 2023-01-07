import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Section 11 CH-98, CH-99, CH-100
public class calendarNew {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Chandu N Nereeksha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");

		// scroll the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1100)");

		// provide just month name and date name (March 23 2023)//click on the date
		// field
		Thread.sleep(3000);
		driver.findElement(By.id("form-field-travel_comp_date")).click();

		// 1.select the month
		// the below loops stops executing when it finds april
		while (!driver.findElement(By.cssSelector(".flatpickr-month")).getText().contains("March")) {
			// click to go to next month
			driver.findElement(By.cssSelector(".flatpickr-next-month")).click();
		}

		// 2.select the date
		// find a property in calendar that is common to every date in the month//put it
		// in a list and iterate
		/*
		 * List<WebElement> dates =
		 * driver.findElements(By.cssSelector(".flatpickr-day"));
		 * 
		 * for(int i = 0; i < dates.size(); i++) { Thread.sleep(2000); String oneDate =
		 * driver.findElements(By.cssSelector(".flatpickr-day")).get(i).getText();
		 * if(oneDate.equalsIgnoreCase("23")) { dates.get(i).click(); break; } }
		 */

		int count = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).size();

		for (int i = 0; i < count; i++)
		{
			Thread.sleep(3000);
			String text = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();

			if (text.equalsIgnoreCase("5"))
			{
				driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
				System.out.println("The select day is:" + text);
				break;
			}
		}
	}

}
