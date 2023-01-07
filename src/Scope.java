import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Section 11 CH-93, CH-94, CH-95, CH-96
public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Chandu N Nereeksha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		// 1.give me the count of the links on the page
		// all links will have anchor tag
		System.out.println(driver.findElements(By.tagName("a")).size());

		// 2.count of links present in the footer section
		// limit the webDriver scope only to the footer section
		// create a webelement for footer and from that web element get the total number
		// of anchor tags - this is called limiting the webdriver scope
		// now the footerDriver(mini driver) plays the role of driver
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		// here footerDriver will act like a new driver
		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		// 3.get the link of only first column in the footer
		// create another driver from footerdriver
		WebElement columnDriver = footerDriver.findElement(By.xpath("(//tbody/tr/td/ul)[1]"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());

		// 4 - click on each link in the column and check if the pages are opening
		int count = columnDriver.findElements(By.tagName("a")).size();
		// String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);

		for (int i = 1; i < count; i++) {

			// open link in new tabs
			// ctrl+enter will open that link in the new tab
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			// sendKeys allows to perform keyboard event
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);

			Thread.sleep(3000);
		}

		//5 - get the titles of all the child tabs
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iT = windows.iterator();

		// hasNext() tells if there is elements present or not
		while (iT.hasNext()) {
			driver.switchTo().window(iT.next());
			System.out.println(driver.getTitle());
		}

	}

}
