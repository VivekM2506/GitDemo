package RahulShettyAcademy.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.testng.Assert;
public class StandAloneTest2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setBinary("C:\\Users\\Dell\\Downloads\\chrome-win64\\chrome.exe");
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverManager.chromedriver().setup();
		String ProdName = "IPHONE 13 PRO";
		LandingPage landingpage =new LandingPage(driver);
		landingpage.Goto();
	    landingpage.LoginAplication("vivek123@gmail.com", "Vivek@123");
	    
	    ProdcutCatalogue prodcutCatalogue =new ProdcutCatalogue(driver);
	    List<WebElement> products=prodcutCatalogue.GetProductsList();
	    prodcutCatalogue.AddToCart(ProdName);
        
	   
	    
	    
	    
	    Thread.sleep(5000);
     
     driver.findElement(By.cssSelector(".btn.btn-custom[routerlink='/dashboard/cart']")).click();
     
     List<WebElement> cartProduct = driver.findElements(By.cssSelector(".cartSection h3"));
     Boolean match = cartProduct.stream().anyMatch(cartprod -> cartprod.getText().equalsIgnoreCase(ProdName));
     Assert.assertTrue(match);
     driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
     
     driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("india");
     
     driver.findElement(By.cssSelector(".ta-item:nth-last-child(2)")).click();
     driver.findElement(By.cssSelector(".action__submit")).click();
     
     String ConfirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
     ConfirmMessage.equalsIgnoreCase("Thankyou for the order.");
     
	}

}
