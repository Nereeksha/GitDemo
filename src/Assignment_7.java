import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Chandu N Nereeksha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,600)");
		System.out.println(
				"Total number of rows : " + driver.findElements(By.xpath("//*[@name='courses']/tbody/tr")).size());
		System.out.println("Total number of columns : "
				+ driver.findElements(By.xpath("//*[@name='courses']/tbody/tr[1]/th")).size());

		System.out.println(driver.findElement(By.xpath("//*[@name='courses']/tbody/tr[3]")).getText());

		/*
		 * driver.get("http://qaclickacademy.com/practice.php");
		 * WebElement table=driver.findElement(By.id("product"));
		 * 
		 * System.out.println(table.findElements(By.tagName("tr")).size());
		 * 
		 * System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(
		 * By.tagName("th")).size());
		 * 
		 * List<WebElement>
		 * secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName
		 * ("td"));
		 * 
		 * System.out.println(secondrow.get(0).getText());
		 * 
		 * System.out.println(secondrow.get(1).getText());
		 * 
		 * System.out.println(secondrow.get(2).getText());
		 */

	}

}
