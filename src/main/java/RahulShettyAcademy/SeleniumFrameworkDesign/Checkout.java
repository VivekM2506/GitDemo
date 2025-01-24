package RahulShettyAcademy.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.abstractComponents.AbstractComponents;

public class Checkout extends AbstractComponents {
	
	WebDriver driver;

	public Checkout(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@class='input txt'])[2]")
	WebElement NameOnCard;
	
	
	@FindBy(css=".btnn")
	WebElement Submit;
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item:last-child")
	WebElement SelectCountry;
	
	public void EnterNameOnCard()
	{
		NameOnCard.sendKeys("Vivek");
	}
	
	public void SelectCountry(String countryname)
	{    Actions a =new Actions(driver);
	     a.sendKeys(country,countryname).build().perform();
	     SelectCountry.click();
	}
	public void SubmitOrder()
	{
		Submit.click();
	}

}
