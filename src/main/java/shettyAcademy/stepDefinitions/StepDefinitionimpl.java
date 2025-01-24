package shettyAcademy.stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import RahulShettyAcademy.SeleniumFrameworkDesign.CartPage;
import RahulShettyAcademy.SeleniumFrameworkDesign.Checkout;
import RahulShettyAcademy.SeleniumFrameworkDesign.LandingPage;
import RahulShettyAcademy.SeleniumFrameworkDesign.ProdcutCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionimpl {
	
	public LandingPage landingpage;
	public ProdcutCatalogue prodcutCatalogue;
	//String ProdName = "IPHONE 13 PRO";
	WebDriver driver;
	@Given( "I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setBinary("C:\\Users\\Dell\\Downloads\\chrome-win64\\chrome.exe");
		driver=new ChromeDriver(options);
		
		landingpage = new LandingPage(driver);
		landingpage.Goto();
		
	}
	
	@Given("^Logged in with username (.+) and Password (.+)$")//(^   $)
	public void Logged_in_with_username_and_Password (String username,String password)
	{
		prodcutCatalogue=landingpage.LoginAplication(username,password);
		driver.manage().window().maximize();
	}
	
	@When("^I add the product (.+) to cart$")
	public void I_add_the_product_to_cart(String product)
	{
		    
		    prodcutCatalogue.GetProductname(product);
		    prodcutCatalogue.AddToCart(product);
	}
	
	@When("^Checkout product (.+)$")
	public void Checkout_product(String product)
	{
		CartPage cartpage=new CartPage(driver);  
	    Checkout checkout=cartpage.GoToCheckout();
	    //Boolean match = cartpage.VerifyProductDisplayed(ProdName);
	    //Assert.assertTrue(match);
	    checkout.EnterNameOnCard();
	    checkout.SelectCountry("India"); 
	    driver.manage().window().maximize();
        checkout.SubmitOrder();
	}
	
	@Then("{string} message is displayed on confirmationPage")
	public void Message_is_displayed_on_confirmationPage(String string)
	{
		  String ConfirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		     ConfirmMessage.equalsIgnoreCase(string);
		     System.out.println(ConfirmMessage);
	}
	
	

}
