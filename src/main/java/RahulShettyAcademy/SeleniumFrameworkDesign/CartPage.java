package RahulShettyAcademy.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.abstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
@FindBy (css =".cartSection h3")
List<WebElement> cartproduct;

@FindBy (xpath="//button[normalize-space()='Checkout']")
WebElement checkout1;


public Boolean VerifyProductDisplayed(String ProdName)
{
	Boolean match = cartproduct.stream().anyMatch(cartprod -> cartprod.getText().equalsIgnoreCase(ProdName));
	return match;
}
public Checkout GoToCheckout()
{
	checkout1.click();
	Checkout checkout=new Checkout(driver);
	return checkout;
}
	
	
	
}
