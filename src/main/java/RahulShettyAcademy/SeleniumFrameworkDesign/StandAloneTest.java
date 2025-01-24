package RahulShettyAcademy.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;


public class StandAloneTest extends BaseTest{

	//public static void main(String[] args) throws InterruptedException {
		@Test
		public void StandAloneTest() throws InterruptedException
		{
		String ProdName = "IPHONE 13 PRO";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setBinary("C:\\Users\\Dell\\Downloads\\chrome-win64\\chrome.exe");
		WebDriver driver=new ChromeDriver(options);
		
		LandingPage landingpage = new LandingPage(driver);
		landingpage.Goto();
	    ProdcutCatalogue prodcutCatalogue=landingpage.LoginAplication("vivek123@gmail.com", "Vivek@123");
	   
	    //ProdcutCatalogue prodcutCatalogue =new ProdcutCatalogue(driver);
	    
	    List<WebElement> products=prodcutCatalogue.GetProductsList();
	    prodcutCatalogue.AddToCart(ProdName);
	    Thread.sleep(4000);
	    prodcutCatalogue.GoToCartpage();
	    
	    CartPage cartpage=new CartPage(driver);
	   
	    Checkout checkout=cartpage.GoToCheckout();
	    Boolean match = cartpage.VerifyProductDisplayed(ProdName);
	    //Assert.assertTrue(match);
	    checkout.EnterNameOnCard();
	    checkout.SelectCountry("India");
	    
	    driver.manage().window().maximize();
        checkout.SubmitOrder();
	    
	    String ConfirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	     ConfirmMessage.equalsIgnoreCase("Thankyou for the order.");
	     System.out.println(ConfirmMessage);
	    
		}
	    
	}

//}
