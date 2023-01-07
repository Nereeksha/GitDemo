import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

//Section 15 Ch-123, Ch-124
public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Chandu N Nereeksha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameLocator = driver.findElement(By.name("name"));
		
		//find the element with tagname label which above name edit box
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameLocator)).getText());
		
		//type in the input box which is below the DOB label
		WebElement DOB = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		//it will skip the input field because relative locators doesn't identify flex elements and it gets to the next input element which is a submit button
		driver.findElement(with(By.tagName("input")).below(DOB)).click();
		
		//select check box which is left to the description
		WebElement label = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(label)).click();
		
		//find the label of the radio button
		WebElement radioButton = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());
		

	}

}
