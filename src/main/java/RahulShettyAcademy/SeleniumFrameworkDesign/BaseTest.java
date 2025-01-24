package RahulShettyAcademy.SeleniumFrameworkDesign;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
	
	public WebDriver driver;
	
	public WebDriver InitiliazeDriver() throws IOException
	{
		Properties properties=new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\test\\java\\SeleniumFrameworkDesign\\resources\\GlobalData.properties");
		properties.load(fis);
		String browsername = properties.getProperty("browser");
		if(browsername.equalsIgnoreCase("chorme"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.setBinary("C:\\Users\\Dell\\Downloads\\chrome-win64\\chrome.exe");
			WebDriver driver=new ChromeDriver(options);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
		
	}
	public void LaunchApplication() throws IOException
	{
		driver=InitiliazeDriver();
		
	}
	
	}


