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
import org.testng.Assert;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Hello World!" );
        
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setBinary("C:\\Users\\Dell\\Downloads\\chrome-win64\\chrome.exe");
		
		//WebDriverManager.chromedriver().setup();
		
    	WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String ProdName = "ZARA COAT 3";
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/client/");
	    
		driver.findElement(By.id("userEmail")).sendKeys("vivek123@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Vivek@123");
		driver.findElement(By.cssSelector("input[id='login']")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
     WebElement product =products.stream().filter(prod->prod.findElement(By.cssSelector("b"))
    		 .getText().equals(ProdName)).findFirst().orElse(null);
     
     product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
     
     
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
     Thread.sleep(7000);
     
     driver.findElement(By.cssSelector(".btn.btn-custom[routerlink='/dashboard/cart']")).click();
     
     List<WebElement> cartProduct = driver.findElements(By.cssSelector(".cartSection h3"));
     Boolean match = cartProduct.stream().anyMatch(cartprod -> cartprod.getText().equalsIgnoreCase(ProdName));
     Assert.assertTrue(match);
     driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
     
     driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("india");
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
     driver.findElement(By.cssSelector(".ta-item:nth-last-child(2)")).click();
     driver.findElement(By.cssSelector(".action__submit")).click();
     
     String ConfirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
     ConfirmMessage.equalsIgnoreCase("Thankyou for the order.");
     
	}
 }

