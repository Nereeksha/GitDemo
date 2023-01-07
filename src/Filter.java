import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//Section 14 Ch-121
public class Filter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Chandu N Nereeksha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		//search for a vegetable in the search box and validate if the results in the table have rice keyword or not
		List<WebElement> searchResults = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> filterList = searchResults.stream().filter(x->x.getText().contains("Rice")).collect(Collectors.toList());
		//The size searchResults and filterList should be same
		Assert.assertEquals(searchResults.size(), filterList.size());
		

	}

}
