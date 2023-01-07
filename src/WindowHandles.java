import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Section 10 CH-88 CH-89
public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandu N Nereeksha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		//selenium shift from parents to child
		//1. first get the window handle ids of all the browser opened by the automation using getWindowHandles()
		Set<String> windows = driver.getWindowHandles(); //[parentid, childid]
		
		//to iterate through the ids in windows set collection
		Iterator<String> iT = windows.iterator();
		String parentID = iT.next(); //moves to zeroth index
		String childID = iT.next(); //moves to 1st index
		
		//2. Switch to child window - pass the window id (switch the driver scope to child window)
		driver.switchTo().window(childID);
		
		//3.get the email id from child tab
		String emailText = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		//4.switch back to parent window
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(emailText);
		
	}

}
