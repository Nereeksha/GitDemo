import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandu N Nereeksha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//1.click on a checkbox
		driver.findElement(By.id("checkBoxOption1")).click();
		
		//2.grab the checkbox label name and print it
		String option = driver.findElement(By.id("checkBoxOption1")).getAttribute("value");
		System.out.println(option);
		
		//3. pass the same value to the dropdown 
		driver.findElement(By.id("dropdown-class-example")).sendKeys(option);
		
		//4. Enter the grabbed text in the alert box
		driver.findElement(By.id("name")).sendKeys(option);
		
		//click on alert and verify if the name of the option is present in the pop-up or not
		driver.findElement(By.id("alertbtn")).click();
		String alert = driver.switchTo().alert().getText();
		
		if(alert.contains("option1"))
		{
			System.out.println("Alert contains string option1");
		}
		else
		{
			System.out.println("Alert doesn't contain string option1");
		}
		
	}
}
