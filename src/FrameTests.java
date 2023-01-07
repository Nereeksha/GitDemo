import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Section 10 CH-91, CH-92
public class FrameTests {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandu N Nereeksha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/droppable/");
		
		//switch to the iframe
		//tell the driver to go into frame and handle the element
		//search from iframes in the website
		//in the below line I have passed Iframe webElement
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		//driver.switchTo().frame(0); - This can be done too to switch to iframe
		
		//To find how many iframes are there in the application - useful when you have to switch using index
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		
		Actions action = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		action.dragAndDrop(source, target).build().perform();
		
		//switch again back from iframe
		driver.switchTo().defaultContent();
		
		
	}
}
