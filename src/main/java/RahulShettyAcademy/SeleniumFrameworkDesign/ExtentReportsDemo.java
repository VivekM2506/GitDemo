package RahulShettyAcademy.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	ExtentReports extent;
	@BeforeTest
	public void config()
	{
		String path= System.getProperty("usr.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Initial Demo Test");
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Vivek");
		
	}
	@Test
	public void InitiaDemo()
	{
		extent.createTest("Initial Demo Test");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setBinary("C:\\Users\\Dell\\Downloads\\chrome-win64\\chrome.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/client/");
		System.out.println(driver.getTitle());
		driver.close();
		extent.flush();
	}
	@Test
	public void Login()
	{
		extent.createTest("Login Test");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setBinary("C:\\Users\\Dell\\Downloads\\chrome-win64\\chrome.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.id("userEmail")).sendKeys("Vivek123@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Vivek@123");
		driver.findElement(By.cssSelector("input[id='login']")).click();
		 driver.close();
		extent.flush();
		
	}
	

}
