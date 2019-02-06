package automation.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import automation.util.Tools;

public class TheDogFatherPage {
	
	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"produtos-info__footer--promo\"]")
	private WebElement elementTest;
	
	@FindBy(how = How.CLASS_NAME, using = "produtos-info__box")
	private List<WebElement> elements;
	
	public TheDogFatherPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public TheDogFatherPage openWebsite() {
		driver.get("https://thedogfatherbrasil.com.br/cardapio-the-dogfather/");
		
		return this;
	}
	
	public List<String> getProducts() {
		Tools.visibilityOf(elementTest, 5, driver);
		
		List<String> products = new ArrayList<String>();
		
		for (WebElement product : elements) {
			String description = product.findElement(By.className("produtos-info__peso")).getText();
			String price = product.findElement(By.className("produtos-info__preco")).getText();
			
			products.add(description + " - " + price);
			System.out.println(description + " - " + price);
		}
		
		return products;
	}

}
