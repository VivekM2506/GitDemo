package RahulShettyAcademy.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.abstractComponents.AbstractComponents;

public class ProdcutCatalogue extends AbstractComponents{
	WebDriver driver;
	
	public ProdcutCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (css = ".mb-3")
	List<WebElement> Products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	By productby=By.cssSelector(".mb-3");// by locator for list of products.
	
	By Addtocart =By.cssSelector("(//button[@class='btn w-10 rounded'][normalize-space()='Add To Cart'])[1]");//.card-body button:last-of-type
	
	By Toast=By.cssSelector("#toast-container");
	
	public List<WebElement> GetProductsList()
	{
		WaitForElementsToAppear(productby);
		return Products;
	}
	
	public WebElement GetProductname(String ProdName)
	{
		WebElement prod= Products.stream().filter(prod1->prod1.findElement(By.cssSelector("b"))
				.getText().equals(ProdName)).findFirst().orElse(null);
		return prod;
		
	}
	public void AddToCart(String ProdName)
	{
   		WebElement prod=GetProductname(ProdName);
   		prod.findElement(Addtocart).click();
   		WaitForElementsToAppear(Toast);
   		WaitForElementToDisappear(spinner);
	}
   		 
	
	
	
}
