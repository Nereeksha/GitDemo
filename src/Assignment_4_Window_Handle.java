import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Windown Handle
public class Assignment_4_Window_Handle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandu N Nereeksha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.xpath("//*[@class='example']/a")).click();
		
		Set<String> winHandles = driver.getWindowHandles();
		Iterator<String> iT = winHandles.iterator();
		String parentId = iT.next();
		String childId = iT.next();
		
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.xpath("//*[@class='example']/h3")).getText());
		
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
		
	}

}
