import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


//To know more about this go to https://chromedriver.chromium.org/capabilities
//Section 13 CH-105, CH-106
public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//To set the behavior of the browser we use ChromeOptions class
		ChromeOptions options = new ChromeOptions();
		
		
		//1. To addd plugins or extensions like like ChroPath or SelectsHub
		//options.addExtensions(null); // give file path name as the arguement
		
		
		//2. To set proxy
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);
		System.out.println("Git Demo");
		System.out.println("Git Demo2");
		
		
		//3.To set download directory manually
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		/*4.Block pop-up window
		options.setExperimentalOption("excludeSwitches",
			     Arrays.asList("disable-popup-blocking"));*/
		
		
		//5.whenever you come across certifications just accept them --> setAcceptInsecureCerts
		options.setAcceptInsecureCerts(true);		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandu N Nereeksha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//pass the chromeoptions object to your chromedriver class
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
