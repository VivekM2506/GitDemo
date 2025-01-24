package RahulShettyAcademy.SeleniumFrameworkDesign;

import java.nio.file.DirectoryStream.Filter;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.dockerjava.api.command.WaitContainerCmd;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setBinary("C:\\Users\\Dell\\Downloads\\chrome-win64\\chrome.exe");
		
		//WebDriverManager.chromedriver().setup();
		
    	WebDriver driver=new ChromeDriver(options);
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	
    	driver.get("https://rahulshettyacademy.com/client/");
    	driver.findElement(By.id("userEmail")).sendKeys("vivek123@gmail.com");
    	driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Vivek@123");
    	driver.findElement(By.cssSelector("input[id='login")).click();
    	
    	
    	
    	
    	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
    	WebElement prod =products.stream().filter(product->product.findElement
    (By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);
    	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
    	
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-animating")));
    	
    	driver.findElement(By.cssSelector(".btn.btn-custom[routerlink='/dashboard/cart']")).click();
    	
    	String productname= "IPHONE 13 PRO";
    	List<WebElement> cartproduct =driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
        Boolean match= cartproduct.stream().anyMatch(cartprod->cartprod.getText().equalsIgnoreCase(productname));
        Assert.assertTrue(match);
        
        driver.findElement(By.cssSelector("li[class='totalRow'] button[type='button']")).click();
    	
        driver.findElement(By.xpath(("(//input[@type='text'])[3]"))).sendKeys("Vivek");
        Actions a =new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"India").build().perform();
        
        driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();
        Thread.sleep(4000);
        
        driver.findElement(By.cssSelector(".action__submit")).click();
        
       String output= driver.findElement(By.cssSelector(".hero-primary")).getText();
       Assert.assertTrue(output.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
       System.out.println(output);
       
       // List<WebElement> cname=driver.findElements(By.cssSelector("button[type='button']"));
        //cname.stream().filter(countryname->)
        
        
        
       // driver.findElement(By.cssSelector(".btnn action__submit ng-star-inserted")).click();
        

	}

}
