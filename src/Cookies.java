import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Section 13 CH-108
public class Cookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandu N Nereeksha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//delete the cookies
		driver.manage().deleteAllCookies();
		//deleting a particular key
		driver.manage().deleteCookieNamed("asdf");
		
		//delete session cookie and when you click on any link you should be navigated back to login page
		driver.manage().deleteCookieNamed("sessionKey");

	}

}
