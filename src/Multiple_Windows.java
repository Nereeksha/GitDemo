import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

//Section 15 Ch-126, Ch-127, Ch-128
public class Multiple_Windows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Chandu N Nereeksha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Scenario
		//Navigate to : https://rahulshettyacademy.com/angularpractice/
		//Fill the 'Name' field with first course name available at https://rahulshettyacademy.com/
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		
		//get the id of the new window and pass it
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iT = handles.iterator();
		String parentID = iT.next();
		String childID = iT.next();
		driver.switchTo().window(childID);
		driver.get("https://rahulshettyacademy.com/");
		
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
		driver.switchTo().window(parentID);
		WebElement nameInput = driver.findElement(By.name("name"));
		nameInput.sendKeys(courseName);
		//driver.quit();
		
		//capture ss of only WebElement (name input box)
		File src = nameInput.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File("NameInput.png"));
		
		//get the height and width of the webelement for UX validations
		System.out.println(nameInput.getRect().getDimension().getHeight());
		System.out.println(nameInput.getRect().getDimension().getWidth());

	}

}
