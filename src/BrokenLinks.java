
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


//Section 13 CH-110, CH-111, CH-112
//Broken URL
public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandu N Nereeksha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Step 1 -is to get all the url's tied up to the links
		//String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		//String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert newAssert = new SoftAssert();
		
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			
			//Step 2 - Java methods will call URL's and get you the status code
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			
			//Step 3 - if status code >400 then that url is not working > link which tied to the url is broken
			int respCode = conn.getResponseCode();
			newAssert.assertTrue(respCode<400, "The link with text "+link.getText()+" is broken with code : "+respCode);
			
			/*if(respCode > 400) {
				System.out.println("The link with Text"+link.getText()+"is broken with code"+respCode);
				Assert.assertTrue(false);
			}*/
		}
		
		//soft assetions will continue the execution but fail the test at the end
		newAssert.assertAll();
		
		
		/*Step 2 - Java methods will call URL's and get you the status code
		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		
		//Step 3 - if status code >400 then that url is not working > link which tied to the url is broken
		int respCode = conn.getResponseCode();
		System.out.println(respCode);*/
	}

}
