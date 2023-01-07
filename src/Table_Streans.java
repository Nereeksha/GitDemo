import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//Section 14 Ch-117, Ch-118
public class Table_Streans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Chandu N Nereeksha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// 1. click on the column so that the column gets sorted
		// 2. capture all the 1st column values into a list
		// 3. capture the text of all the webelements into new list -> original list
		// 4. apply sort on that new list -> sortedList
		// 5. compare original list v/s sorted list
		driver.findElement(By.xpath("//table/thead/tr/th[1]")).click();

		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList = veggies.stream().map(x -> x.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));

		// get price of each vegetable which is in another column
		// scan the veg name column and getText -> Rice -> print the price of that
		// vegetable

		List<String> price;
		
		//performs pagination if the desired vegetable is not present in the 1st page
		do {
			List<WebElement> tableVeg = driver.findElements(By.xpath("//tr/td[1]"));
			price = tableVeg.stream().filter(y -> y.getText().contains("Rice")).map(x -> getPriceVeggie(x))
					.collect(Collectors.toList());
			price.forEach(x->System.out.println(x)); //-> if you want to print all the
			// elements
			//System.out.println(price.get(0));

			// if there is no desired element in page 1 table got to second page
			if (price.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();

			}
		} while (price.size() < 1);

	}

	public static String getPriceVeggie(WebElement veg) {

		return veg.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
