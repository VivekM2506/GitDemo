package RahulShettyAcademy.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.abstractComponents.AbstractComponents;
import net.bytebuddy.implementation.bind.annotation.Super;

public class LandingPage extends AbstractComponents{

	WebDriver driver;
	
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(id ="userEmail")
	WebElement EmailId;
	
	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement Password;
	
	//@FindBy(id="userPassword")
	//WebElement Password;
	
	@FindBy(css = "input[id='login']")
	WebElement Submit;
	
	//WebElement EmailId = driver.findElement(By.id("userEmail"));
	public void Goto()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}

	public ProdcutCatalogue LoginAplication(String email,String password)
	{
		
		EmailId.sendKeys(email);
		Password.sendKeys(password);
		Submit.click();
		ProdcutCatalogue prodcutCatalogue =new ProdcutCatalogue(driver);
		return prodcutCatalogue;
	}

}
